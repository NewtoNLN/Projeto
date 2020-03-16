package com.pitang.Projeto.service;

import java.util.List;

import com.pitang.Projeto.Model.ModelUsuario;

public interface ServiceUsuario {
	
	public List<ModelUsuario> listUsers();
	
	public ModelUsuario findUserByUsername(String userName);
	
	public ModelUsuario addUser(ModelUsuario user);
	
	public ModelUsuario updateUser(Long id, ModelUsuario user);
	
	public void deleteUser(Long id);
	
	public ModelUsuario findUserById(Long id);
	
	public ModelUsuario findByEmail(String email);
	
	
	
	

}
