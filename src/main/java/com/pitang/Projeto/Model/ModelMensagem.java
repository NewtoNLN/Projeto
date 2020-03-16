package com.pitang.Projeto.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "message")
public class ModelMensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull 
	@Size(max = 100)
	@Column(name = "message")
	private String message;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_sender", nullable = false)
	private ModelUsuario userSender;
	
	@NotNull 
	@Column(name = "userReciever")
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

	public ModelUsuario getUserSender() {
		return userSender;
	}

	public void setUserSender(ModelUsuario userSender) {
		this.userSender = userSender;
	}

	public Long getUserReciever() {
		return userReciever;
	}

	public void setUserReciever(Long userReciever) {
		this.userReciever = userReciever;
	}
	

	
}
