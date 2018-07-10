package com.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="superadmin")
public class SuperAdmin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="superAdminId")
	private String adminId;
	
	@Column(name="superAdminName")
	private String superAdminName;
	
	@Column(name="superAdminPassword")
	private String superAdminPassword;
	
	@Column(name="superAdminEmail")
	private String superAdminEmail;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getSuperAdminName() {
		return superAdminName;
	}

	public void setSuperAdminName(String superAdminName) {
		this.superAdminName = superAdminName;
	}

	public String getSuperAdminPassword() {
		return superAdminPassword;
	}

	public void setSuperAdminPassword(String superAdminPassword) {
		this.superAdminPassword = superAdminPassword;
	}

	public String getSuperAdminEmail() {
		return superAdminEmail;
	}

	public void setSuperAdminEmail(String superAdminEmail) {
		this.superAdminEmail = superAdminEmail;
	}

	public SuperAdmin(String adminId, String superAdminName, String superAdminPassword, String superAdminEmail) {
		this.adminId = adminId;
		this.superAdminName = superAdminName;
		this.superAdminPassword = superAdminPassword;
		this.superAdminEmail = superAdminEmail;
	}
	
	public SuperAdmin() {
		
	}

}
