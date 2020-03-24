package com.pitang.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoMensagem {
	
	private Long id;
	private String message;
	private Long idSender;
	private Long idReciever;
	
	
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
	public Long getIdSender() {
		return idSender;
	}
	public void setIdSender(Long idSender) {
		this.idSender = idSender;
	}
	public Long getIdReciever() {
		return idReciever;
	}
	public void setIdReciever(Long idReciever) {
		this.idReciever = idReciever;
	}
	
	
}
