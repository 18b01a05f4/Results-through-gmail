package com.model;

public class StudentDTO {
	private String regNumber;
	private String emailId;
	public StudentDTO(String regNumber, String emailId) {
		super();
		this.regNumber = regNumber;
		this.emailId = emailId;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
