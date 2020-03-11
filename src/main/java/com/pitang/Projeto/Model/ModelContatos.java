
package com.pitang.Projeto.Model;

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
@Table(name = "contact")
public class ModelContatos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "contact_name")
	private String contactName;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_sender", nullable = false)
	private ModelUsuario userSender;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_reciever", nullable = false)
	private ModelUsuario userReciever;
	
	public ModelContatos() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public ModelUsuario getUserSender() {
		return userSender;
	}

	public void setUserSender(ModelUsuario userSender) {
		this.userSender = userSender;
	}

	public ModelUsuario getUserReciever() {
		return userReciever;
	}

	public void setUserReciever(ModelUsuario userReciever) {
		this.userReciever = userReciever;
	}

	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}	
}
