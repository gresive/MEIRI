package com.meiri.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
   
   private static final long serialVersionUID = 1004L;
   
   private String userId;   
   private String passWord;  
   private String userName;
   private String address;   
   private String email;    
   private int birth;         
   private String phone;    
   
   public Member() { }
   

   public Member(String userId, String passWord) {
	super();
	this.userId = userId;
	this.passWord = passWord;
}

public Member(String userId, String passWord, String userName, String address, String email, int birth, String phone) {
	super();
	this.userId = userId;
	this.passWord = passWord;
	this.userName = userName;
	this.address = address;
	this.email = email;
	this.birth = birth;
	this.phone = phone;
}

@Override
public String toString() {
	return "Member [userId=" + userId + ", passWord=" + passWord + ", userName=" + userName + ", address=" + address
			+ ", email=" + email + ", birth=" + birth + ", phone=" + phone + "]";
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getBirth() {
	return birth;
}

public void setBirth(int birth) {
	this.birth = birth;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}
   
   
   
   
  
}