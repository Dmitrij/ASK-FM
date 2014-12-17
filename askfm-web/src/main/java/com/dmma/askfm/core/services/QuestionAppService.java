package com.dmma.askfm.core.services;

import java.util.List;

import com.dmma.askfm.dto.shared.dtos.QuestionDTO;
import com.dmma.askfm.dto.shared.wrappers.QuestionSubmissionResponse;


/**
 * Main business layer service, dealing with "Questions" 
 * @author Dima 
 * */
public interface QuestionAppService {
	
	/**
	 * Reads all accepted questions stored in a system.
	 * @return List of {@link QuestionDTO}
	 **/
	List<QuestionDTO> findAllAccepted();
	
	/**
	 * Reads accepted questions by country code stored in a system.
	 * @param code is a literal country code
	 * @return List of {@link QuestionDTO}
	 **/
	List<QuestionDTO> findAllAcceptedByCountry(String code);
	
	/**
	 * Reads question by id.
	 * @param id - question unique identifier
	 * @return {@link QuestionDTO}
	 **/
	QuestionDTO readQuestion(Long id);
	
	/**
	 * Tries to save proposed question.<br>
	 * Performs several business checks, like profanity and question frequency.
	 * @param questionText - text provided by requestor (client)
	 * @param remoteAddr - IP address of a requestor (client)
	 * @return {@link QuestionSubmissionResponse}
	 **/
	QuestionSubmissionResponse publishQuestion(String questionText, String remoteAddr);
	
}
