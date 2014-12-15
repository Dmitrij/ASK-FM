package com.dmma.askfm.dto.shared.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 */
@XmlRootElement(name="questionDTO")
public class QuestionDTO implements Serializable  {

	// --- Variables ---
	private Long ID;
	private String text;
	private String countryCode;
	private Boolean accepted;
	private Date created;


	// --- Methods ---
	public QuestionDTO() {}

	public QuestionDTO(Long ID, String text, String countryCode, Boolean accepted, Date created) {
		this.ID = ID;
		this.text = text;
		this.countryCode = countryCode;
		this.accepted = accepted;
		this.created = created;
	}

	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
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
