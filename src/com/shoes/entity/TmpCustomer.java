package com.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tmpCustomer")
public class TmpCustomer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="userId")
	private int userId;
	
	@Column(name="userTrueName")
	private String userTrueName;
	
	@Column(name="userNickname")
	private String userNickname;
	
	@Column(name="userPassword")
	private String userPassword;
	
	@Column(name="userSex")
	private String userSex;
	
	@Column(name="userPhone")
	private String userPhone;
	
	@Column(name="userAddress")
	private String userAddress;
	
	@Column(name="userIdentification")
	private String userIdentification;
	
	@Column(name="userEmail")
	private String userEmail;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userTrueName=" + userTrueName + ", userNickname=" + userNickname
				+ ", userPassword=" + userPassword + ", userSex=" + userSex + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + ", userIdentification=" + userIdentification + ", userEmail="
				+ userEmail + "]";
	}

	
}
