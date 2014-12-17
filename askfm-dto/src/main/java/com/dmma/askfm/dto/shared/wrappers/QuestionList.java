package com.dmma.askfm.dto.shared.wrappers;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.dmma.askfm.dto.shared.dtos.QuestionDTO;


/**
 * A wrapper for list of question.  
 * 
 * @author <a href="dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 */
@XmlRootElement(name="questionList")
public class QuestionList implements Serializable  {

	// --- Variables ---
	private List<QuestionDTO> questions;
	
	// --- Methods ---
	public QuestionList() {}

	public QuestionList(List<QuestionDTO> questions) {
		this.questions = questions;
	}
	
	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

	

}
