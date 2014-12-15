package com.dmma.askfm.core.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


public class QuestionAppServiceImpl implements QuestionAppService {
	private final static Logger LOG = LoggerFactory.getLogger(QuestionAppServiceImpl.class);
	
	public QuestionAppServiceImpl() {
		LOG.info("ControlAppServiceImpl - init");
	}

	@Override
	public List<QuestionDTO> findAllAccepted() {
		QuestionDTO q1 = new QuestionDTO(1l, "text1", "LV", true, new Date());
		QuestionDTO q2 = new QuestionDTO(2l, "text2", "BE", true, new Date());
		QuestionDTO q3 = new QuestionDTO(3l, "text3", "BE", true, new Date());
		QuestionDTO q4 = new QuestionDTO(4l, "text4", "LV", true, new Date());
		
		return Arrays.asList(q1,q2,q3,q4);
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
	
}
