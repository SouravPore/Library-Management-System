package com.proj.model;

import java.sql.Date;

public class IssusedBookInfo {
	
	private String callno,studentid,studentname;
	private long studentphno;
	private Date issueddate;
	private String returnstatus;

	public IssusedBookInfo() {}
	
	public IssusedBookInfo(String callno, String studentid, String studentname, long studentphno) {
		super();
		this.callno = callno;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentphno = studentphno;
	}

	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentphno() {
		return studentphno;
	}
	public void setStudentphno(long studentphno) {
		this.studentphno = studentphno;
	}

}
