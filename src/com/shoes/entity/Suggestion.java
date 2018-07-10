package com.shoes.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suggestion")
public class Suggestion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Theme")
	private String theme;
	
	@Column(name="Content")
	private String content;
	
	@Column(name="Time")
	private Date time;
	
	@Column(name="Handle")
	private int handle;
	
	@Column(name="Phone")
	private String phone;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTheme() {
		return theme;
	}



	public void setTheme(String theme) {
		this.theme = theme;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
	}



	public int getHandle() {
		return handle;
	}



	public void setHandle(int handle) {
		this.handle = handle;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", name=" + name + ", theme=" + theme + ", content=" + content + ", time="
				+ time + ", handle=" + handle + ", phone=" + phone + "]";
	}

	

	public Suggestion(String name, String theme, String content, Date time, int handle, String phone) {
		this.name = name;
		this.theme = theme;
		this.content = content;
		this.time = time;
		this.handle = handle;
		this.phone = phone;
	}

	public Suggestion() {
		
	}

}
