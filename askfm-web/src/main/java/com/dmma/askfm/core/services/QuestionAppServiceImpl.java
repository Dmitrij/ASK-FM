package com.dmma.askfm.core.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.core.configuration.AppProperties;
import com.dmma.askfm.core.mappers.QuestionMapper;
import com.dmma.askfm.db.daos.QuestionDAO;
import com.dmma.askfm.db.entities.Question;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


public class QuestionAppServiceImpl implements QuestionAppService {
	// --- Constants ---
	private final static Logger LOG = LoggerFactory.getLogger(QuestionAppServiceImpl.class);
	
	private final Map<String, Long> lastRequest = new ConcurrentHashMap<String, Long>();
	private final Long minQuestionInterval;  
	
	// --- Variables ---
	private ProfanityAppService profanityAppService;
	private LocationAppService locationAppService;
	private QuestionDAO questionDAO;
	
	// --- Methods ---
	public QuestionAppServiceImpl() {
		LOG.info("ControlAppServiceImpl - init");
		Double interval = 1000 / AppProperties.questionsPerSecond;
		minQuestionInterval = interval.longValue();
	}

	@Override
	public List<QuestionDTO> findAllAccepted() {
		return QuestionMapper.toDTOs(questionDAO.findAll());
	}

	@Override
	public List<QuestionDTO> findAllAcceptedByCountry(String code) {
		if(code == null )
			return null;
		return QuestionMapper.toDTOs(questionDAO.findByCountryCode(code.toLowerCase()));
	}

	@Override
	public QuestionDTO readQuestion(Long id) {
		return QuestionMapper.toDTO(questionDAO.findById(id));
	}

	@Override
	public QuestionSubmissionResponse publishQuestion(String questionText, String remoteAddr) {
		QuestionSubmissionResponse retVal = new QuestionSubmissionResponse();
		
		Boolean passed = profanityAppService.validateText(questionText);
		if(!passed){
			retVal.setErrorMsg("profanity check failed");
			retVal.setStatusCode(0);
			return retVal;
		}
		
		String countryCode = locationAppService.detectCountryCode(remoteAddr);
		Long now = new Date().getTime();
		Long latTimeStamp = lastRequest.get(countryCode);
		if(latTimeStamp != null && latTimeStamp > now - minQuestionInterval ){
			retVal.setErrorMsg("too many requests");
			retVal.setStatusCode(0);
			return retVal;
		}
		
		lastRequest.put(countryCode, now);
		
		Question entity = new Question(questionText, countryCode);
		questionDAO.saveOrUpdate(entity);
		
		retVal.setQuestionId(entity.getId());
		retVal.setCountryCode(countryCode);
		
		return retVal;
	
	}

	// --- Spring setters ---
	public void setProfanityAppService(ProfanityAppService profanityAppService) {
		this.profanityAppService = profanityAppService;
	}

	public void setLocationAppService(LocationAppService locationAppService) {
		this.locationAppService = locationAppService;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	
}
