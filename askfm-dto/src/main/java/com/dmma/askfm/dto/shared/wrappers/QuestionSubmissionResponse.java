package com.dmma.askfm.dto.shared.wrappers;

import javax.xml.bind.annotation.XmlRootElement;

/**
 */
@XmlRootElement(name="questionSubmissionResponse")
public class QuestionSubmissionResponse {
	private Integer statusCode;
	private Long questionId;
	private String countryCode;
	private String errorMsg;
	
	public QuestionSubmissionResponse() {
		this.statusCode = 1;
	}
	
	public QuestionSubmissionResponse(String errorMsg) {
		this.statusCode = 0;
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public Integer getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	
}
