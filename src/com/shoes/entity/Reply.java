package com.shoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Id")
	private int id;
	
	@Column(name="Content")
	private String content;
	
	@Column(name="SuggestionId")
	private int suggestionId;
	
	@Column(name="ToUser")
	private String toUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}

	
	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	@Override
	public String toString() {
		return "reply [id=" + id + ", content=" + content + ", suggestionId=" + suggestionId + "]";
	}

	public Reply(String content, int suggestionId, String toUser) {
		this.content = content;
		this.suggestionId = suggestionId;
		this.toUser = toUser;
	}
	
	public Reply() {
		
	}

}
