package com.dmma.askfm.core.scheduling.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.dmma.askfm.core.services.QuestionAppService;

public class WhateverScheduledJob {
	private final static Logger LOG = LoggerFactory.getLogger(WhateverScheduledJob.class);
	
	// --- Variables ---
	@SuppressWarnings("unused")
	private QuestionAppService questionAppService;
		
	public WhateverScheduledJob() {
		LOG.info("WhateverScheduledJob bean created.");
	}
	
	@Scheduled(fixedDelay=60000)
	public void executeBattaryStatusUpdate(){
		LOG.debug("here could be your ad :) ");
	}

	// -- Spring Setters --
	public void setQuestionAppService(QuestionAppService questionAppService) {
		this.questionAppService = questionAppService;
	}

	

}
