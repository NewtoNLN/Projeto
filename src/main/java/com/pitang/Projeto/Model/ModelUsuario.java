package com.pitang.Projeto.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")	
public class ModelUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "user_name")
	private String userName;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "complete_name")
	private String completeName;
	
	@NotNull
	@Email
	@Size(max = 100)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Size(max = 100)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY ,
				cascade = CascadeType.ALL,
				mappedBy = "userSender")
	private List<ModelContatos> contact;
	
	
	@OneToMany(fetch = FetchType.LAZY , 
				cascade = CascadeType.ALL,
				mappedBy = "idSender")
	private List<ModelMensagem> messages;
	
	
	
	public ModelUsuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
