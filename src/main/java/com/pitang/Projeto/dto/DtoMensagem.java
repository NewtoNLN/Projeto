package com.pitang.Projeto.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoMensagem {
	
	private Long id;
	private String message;
	private DtoUsuario userSender;
	private DtoUsuario userReciever;
	
	
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
	public DtoUsuario getUserSender() {
		return userSender;
	}
	public void setUserSender(DtoUsuario userSender) {
		this.userSender = userSender;
	}
	public DtoUsuario getUserReciever() {
		return userReciever;
	}
	public void setUserReciever(DtoUsuario userReciever) {
		this.userReciever = userReciever;
	}	
	
}
