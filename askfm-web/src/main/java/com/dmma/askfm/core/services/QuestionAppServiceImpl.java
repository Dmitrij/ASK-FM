package com.dmma.askfm.core.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.core.mappers.QuestionMapper;
import com.dmma.askfm.db.daos.QuestionDAO;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


public class QuestionAppServiceImpl implements QuestionAppService {
	private final static Logger LOG = LoggerFactory.getLogger(QuestionAppServiceImpl.class);
	
	private QuestionDAO questionDAO;
	
	public QuestionAppServiceImpl() {
		LOG.info("ControlAppServiceImpl - init");
	}

	@Override
	public List<QuestionDTO> findAllAccepted() {
		return QuestionMapper.toDTOs(questionDAO.findAll());
	}

	@Override
	public List<QuestionDTO> findAllAcceptedByCountry(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionDTO readQuestion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionSubmissionResponse publishQuestion(String questionText) {
		// TODO Auto-generated method stub
		return null;
	}

	// --- Spring setters ---
	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	
}
