package com.dmma.askfm.web.spring.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmma.askfm.core.services.QuestionAppService;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;

@Controller
public class AppSimpleController {
	private final static Logger LOG = LoggerFactory.getLogger(AppSimpleController.class);
	
	// --- Variables ---
	@Autowired
	private QuestionAppService questionAppService;
	
	public AppSimpleController() {
		LOG.info("Starting AppSimpleController ... ");
	}

	@RequestMapping("/index.do")
	public String handleIndexRequest(){
		return "index";
	}
	
	@RequestMapping("/questionlist.do")
	public String handleQuestionlistRequest(ModelMap model){
		List<QuestionDTO> questionlist = questionAppService.findAllAccepted();
		model.put("questionlist", questionlist);
		return "questionlist";
	}
	
	@RequestMapping("/questionlistbycountry.do")
	public String handleQuestionlistByCountryRequest(@RequestParam("country") String country,  ModelMap model){
		List<QuestionDTO> questionlist = questionAppService.findAllAcceptedByCountry(country);
		model.put("questionlist", questionlist);
		return "questionlist";
	}
		
	// -- Spring setters --
	public void setQuestionAppService(QuestionAppService questionAppService) {
		this.questionAppService = questionAppService;
	}

}
