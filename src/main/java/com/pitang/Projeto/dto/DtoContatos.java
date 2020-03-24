package com.pitang.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoContatos {
	
	private Long id;
	private String contactName;
	private Long userSender;
	private Long userReciever;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getUserSender() {
		return userSender;
	}
	public void setUserSender(Long userSender) {
		this.userSender = userSender;
	}
	public Long getUserReciever() {
		return userReciever;
	}
	public void setUserReciever(Long userReciever) {
		this.userReciever = userReciever;
	}
	
	
	
}
