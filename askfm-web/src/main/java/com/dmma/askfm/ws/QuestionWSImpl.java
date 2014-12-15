package com.dmma.askfm.ws;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.dmma.askfm.core.services.QuestionAppService;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


@WebService(endpointInterface = "com.dmma.askfm.ws.QuestionWS", serviceName = "QuestionWS")
@Path("/QuestionWS")
public class QuestionWSImpl implements QuestionWS{
	
	// --- Variables ---
	private QuestionAppService questionAppService;
	
	// --- Methods ---
	@Override
	public List<QuestionDTO> findAllAccepted() {
		return questionAppService.findAllAccepted();
	}
	
	@Override
	public List<QuestionDTO> findAllAcceptedByCountry(String code) {
		return questionAppService.findAllAcceptedByCountry(code);
	}
	
	@Override
	public QuestionSubmissionResponse publishQuestion(String questionText) {
		return questionAppService.publishQuestion(questionText);
	}

	// -- Setters --
	public void setQuestionAppService(QuestionAppService questionAppService) {
		this.questionAppService = questionAppService;
	}

}
