package com.meiri.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {
	
	private static final long serialVersionUID = 1004L;
	
	private String userId;   
	private String passWord;  
	private String userName;
	private int birth;         
	private String email;    
	private String phone;    
	private String address;   
	private Date enrollDate;
	
	public Member() { }
	
	
	public Member(String userId, String passWord, String userName, int birth, String email, String phone,
			String address, Date enrollDate) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
	} 
	
	public Member(String userId, String passWord) {
		super();
		this.userId = userId;
		this.passWord = passWord;
	}

	

	public Member(String userId, String passWord, String userName, int birth, String email, String phone,
			String address) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	


	@Override
	public String toString() {
		return "Member [userId=" + userId + ", passWord=" + passWord + ", userName=" + userName +  ", birth=" + birth + ", email=" + email + ", phone=" + phone + ", address=" + address + ", enrollDate="
				+ enrollDate + "]";
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return passWord;
	}


	public void setpassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getbirth() {
		return birth;
	}


	public void setbirth(int birth) {
		this.birth = birth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getPassWord() {
		// TODO Auto-generated method stub
		return null;
	}


	


	
	

}
