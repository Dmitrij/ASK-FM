package com.dmma.askfm.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION" )
public class Question {

	// --- Variables ---
	@Id()
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "QUESTION_TEXT") 
	private String  questionText;

	@Column(name = "COUNTRY_CODE") 
	private String  countryCode;

	@Column(name = "ACCEPTED") 
	private Boolean accepted;
	
	@Column(name = "CREATED") 
	private Date  created;

	// --- Methods ---
	public Question(){
		created = new Date();
		accepted = false;
	}
	
	public Question(String questionText, String countryCode){
		this.questionText = questionText;
		this.countryCode = countryCode;
		created = new Date();
		accepted = true;
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


