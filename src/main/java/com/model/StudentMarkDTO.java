package com.model;

public class StudentMarkDTO {
	private String regNumber;
	private String emailId;
	private int dwdm,infosec,wt,cc,ajp,ecom;
	
	
	
	public StudentMarkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentMarkDTO(String regNumber, String emailId, int dwdm, int infosec, int wt, int cc, int ajp, int ecom) {
		super();
		this.regNumber = regNumber;
		this.emailId = emailId;
		this.dwdm = dwdm;
		this.infosec = infosec;
		this.wt = wt;
		this.cc = cc;
		this.ajp = ajp;
		this.ecom = ecom;
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
	public int getDwdm() {
		return dwdm;
	}
	public void setDwdm(int dwdm) {
		this.dwdm = dwdm;
	}
	public int getInfosec() {
		return infosec;
	}
	public void setInfosec(int infosec) {
		this.infosec = infosec;
	}
	public int getWt() {
		return wt;
	}
	public void setWt(int wt) {
		this.wt = wt;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getAjp() {
		return ajp;
	}
	public void setAjp(int ajp) {
		this.ajp = ajp;
	}
	public int getEcom() {
		return ecom;
	}
	public void setEcom(int ecom) {
		this.ecom = ecom;
	}
	
}
