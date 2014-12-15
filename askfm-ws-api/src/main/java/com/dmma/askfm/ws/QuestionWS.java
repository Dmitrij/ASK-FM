package com.dmma.askfm.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;

@WebService
public interface QuestionWS {
	
	List<QuestionDTO> findAllAccepted();
	
	List<QuestionDTO> findAllAcceptedByCountry(@WebParam(name = "code") String code);
	
	QuestionSubmissionResponse publishQuestion(@WebParam(name = "questionText") String questionText);
	
}
