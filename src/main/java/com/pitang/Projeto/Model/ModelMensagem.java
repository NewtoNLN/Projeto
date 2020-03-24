package com.pitang.Projeto.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_sender", nullable = false)
	private ModelUsuario idSender;
	
	@NotNull
	@Column(name = "id_reciever")
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

	public ModelUsuario getIdSender() {
		return idSender;
	}

	public void setIdSender(ModelUsuario idSender) {
		this.idSender = idSender;
	}

	public Long getIdReciever() {
		return idReciever;
	}

	public void setIdReciever(Long idReciever) {
		this.idReciever = idReciever;
	}

	
	
	
	

	
}
