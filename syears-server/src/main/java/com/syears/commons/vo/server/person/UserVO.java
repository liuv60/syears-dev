package com.syears.commons.vo.server.person;
/**
 * Created on 2015-09-01.
 * 
 * @author liulin
 *
 */

public class UserVO {

    private String userID;
    
    private String userName;
    
    private String fullName; //姓名
    
    private String tel;
    
    private String qq;
    
    private String weixin;
    
    private String password;
    
    private String sex;
    
    private String regDate; //注册时间
   
    private String personID;  //个人信息ID


    
    
    public  String getUserID(){
    	return this.userID;
    }
    public  void setUserID(String userID){
    	this.userID = userID;
    }
    
    
    public String getUserName(){
    	return this.userName;
    }
    
    public void setUserName(String username){
    	this.userName = username;
    }
    
    
    public String getFullName(){
    	return this.fullName;
    }
    
    public void setFullName(String fullname){
    	this.fullName = fullname;
    }
    
    
    public String getTel(){
    	return tel;
    }
    
    public void setTel(String tel){
    	this.tel = tel;
    }
    
    
    public String getQq(){
    	return this.qq;
    }
    
    public void setQq(String qq){
    	this.qq = qq;
    }
    
    
    public String getWeixin(){
    	return this.weixin;
    }
    
    public void setWeixin(String wx){}
    
    
    public String getPassword(){
    	return this.password;
    }
    
    public void setPassword(String pass){}
    
    
    public String getSex(){
    	return this.sex;
    }
    
    public void setSex(String sex){}
    
    
    public String getRegDate(){
    	return this.regDate;
    }
    
    public void setRegDate(String date){}
    
    
    public String getPersonID(){
    	return this.personID;
    }
    
    public void setPersonID(String pid){
    	this.personID = pid;
    }
    
}