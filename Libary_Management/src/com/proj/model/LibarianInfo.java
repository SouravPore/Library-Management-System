package com.proj.model;

import java.io.Serializable;

public class LibarianInfo implements Serializable {

	private String name;
	private String email;
	private String password;
	private String mobileno;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getMobileno()
	{
		return mobileno;
	}
	public void  setMobileno(String mobileno)
	{
		this.mobileno=mobileno;
	}
	
}
