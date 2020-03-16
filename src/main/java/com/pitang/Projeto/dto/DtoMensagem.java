package com.pitang.Projeto.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoMensagem {
	
	private Long id;
	private String message;
	private Long userSender;
	private Long userReciever;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
