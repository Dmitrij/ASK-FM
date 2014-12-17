package com.dmma.askfm.dto.shared.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Simple DTO that will contain the Question published by client
 * 
 * @author <a href="dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 */
@XmlRootElement(name="questionDTO")
public class QuestionDTO implements Serializable  {

	// --- Variables ---
	private Long id;
	private String questionText;
	private String countryCode;
	private Boolean accepted;
	private Date created;

	// --- Methods ---
	public QuestionDTO() {}

	public QuestionDTO(Long id, String text, String countryCode, Boolean accepted, Date created) {
		this.id = id;
		this.questionText = text;
		this.countryCode = countryCode;
		this.accepted = accepted;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
