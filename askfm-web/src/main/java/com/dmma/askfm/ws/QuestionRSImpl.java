package com.dmma.askfm.ws;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.core.services.QuestionAppService;
import com.dmma.askfm.dto.shared.constants.RSParams;
import com.dmma.askfm.dto.shared.constants.RSPaths;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionList;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


public class QuestionRSImpl {

	protected final Logger log = LoggerFactory.getLogger(QuestionRSImpl.class);
	
	// --- Variables ---
	private QuestionAppService questionAppService;

	// --- Methods ---
	
	@GET
	@Path(RSPaths.RS_PATH_questionListGET)
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getQuestionListGET(){
		List<QuestionDTO> questionList = questionAppService.findAllAccepted();
		return Response.ok(new QuestionList(questionList)).build();
	}

	@POST
	@Path(RSPaths.RS_PATH_questionListPOST)
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getQuestionListPOST(){
		List<QuestionDTO> questionList = questionAppService.findAllAccepted();
		return Response.ok(new QuestionList(questionList)).build();
	}
	
	
	@GET
	@Path(RSPaths.RS_PATH_questionListByCountryGET+"/{"+RSParams.countryCode+"}")
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getQuestionListByCountryGET(@PathParam(RSParams.countryCode) String countryCode){
		List<QuestionDTO> questionList = questionAppService.findAllAcceptedByCountry(countryCode);
		return Response.ok(new QuestionList(questionList)).build();
	}
	
	@POST
	@Path(RSPaths.RS_PATH_questionListByCountryPOST)
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getQuestionListByCountryPOST(@FormParam(RSParams.countryCode) String countryCode) {
		List<QuestionDTO> questionList = questionAppService.findAllAcceptedByCountry(countryCode);
		return Response.ok(new QuestionList(questionList)).build();
	}
	
	
	@GET
	@Path(RSPaths.RS_PATH_publishQuestionGET + "/{"+RSParams.questionText+"}")
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response publishQuestionGET(@PathParam(RSParams.questionText) String questionText, @Context HttpServletRequest req){
		String remoteAddr = req.getRemoteAddr();
		QuestionSubmissionResponse result = questionAppService.publishQuestion(questionText, remoteAddr);
		return Response.ok(result).build();
	}
	
	
	@POST
	@Path(RSPaths.RS_PATH_publishQuestionPOST)
	@Produces("application/json")
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response publishQuestionPOST(@FormParam(RSParams.questionText) String questionText, @Context HttpServletRequest req) {
		//String remoteHost = req.getRemoteHost();
	    String remoteAddr = req.getRemoteAddr();
	    QuestionSubmissionResponse result = questionAppService.publishQuestion(questionText, remoteAddr);
		return Response.ok(result).build();
	}
	

	// -- Setters --
	public void setQuestionAppService(QuestionAppService questionAppService) {
		this.questionAppService = questionAppService;
	}
	
}

