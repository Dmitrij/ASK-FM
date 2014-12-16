package com.dmma.askfm.core.services;

import java.util.List;

import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;



public interface QuestionAppService {
	
	List<QuestionDTO> findAllAccepted();
	
	List<QuestionDTO> findAllAcceptedByCountry(String code);
	
	QuestionDTO readQuestion(Long id);
	
	QuestionSubmissionResponse publishQuestion(String questionText, String remoteAddr);
	
}
