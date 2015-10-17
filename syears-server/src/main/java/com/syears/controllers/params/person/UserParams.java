package com.syears.controllers.params.person;

public class UserParams {
	private String userName;
	private String password;
	private Integer userStatus;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer status) {
		this.userStatus = status;
	}

}
