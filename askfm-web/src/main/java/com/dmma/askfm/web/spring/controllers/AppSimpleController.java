package com.dmma.askfm.web.spring.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmma.askfm.core.services.QuestionAppService;

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
	
	
	// -- Spring setters --
	public void setQuestionAppService(QuestionAppService questionAppService) {
		this.questionAppService = questionAppService;
	}

}
