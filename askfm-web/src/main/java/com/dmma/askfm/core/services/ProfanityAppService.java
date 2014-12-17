package com.dmma.askfm.core.services;

/**
 * Profanity filter - a service able to detect bad words 
 * @author Dima 
 * */
public interface ProfanityAppService {
	
	/**
	 * Validates input text against "bad words"
	 * @param text is a subject to be checked
	 * @return check result - true is passed, false if input contains bad words
	 **/
	Boolean validateText(String text);
	
}
