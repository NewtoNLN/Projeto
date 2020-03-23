package com.pitang.Projeto.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pitang.Projeto.Exceptions.ExceptionBadRequest;
import com.pitang.Projeto.Exceptions.ExceptionConflict;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.repository.RepositoryUsuario;
import com.pitang.Projeto.service.ServiceUsuario;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {

	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	
	
	@Override
	public List<ModelUsuario> listUsers(){
		if (repositoryUsuario.findAll().size() == 0) {
			return null;
		}
		return repositoryUsuario.findAll();
	}
	
	@Override
	public ModelUsuario findUserByUsername(String userName) {
		return repositoryUsuario.findByUserName(userName);
	}
	
	@Override
	public ModelUsuario findUserById(Long id) {
		Optional<ModelUsuario>  user = repositoryUsuario.findById(id);
		if(!user.isPresent()) {
			throw new ExceptionBadRequest("Usuário não encontrado.");
		}
		return user.get();
	}
	@Override
	public ModelUsuario findByEmail(String email) {
		return repositoryUsuario.findByEmail(email);
	}
	
	@Override
	public ModelUsuario addUser(ModelUsuario user) {
		checkMandatoryFields(user);
		validadeUser(user);
		return repositoryUsuario.save(user);
	}
	
	
	@Override
	public ModelUsuario updateUser(ModelUsuario user) {
		if (user.getId() == null) {
			throw new ExceptionBadRequest("Necessário informar ID do usuário.");
		}
		checkMandatoryFields(user);
		return repositoryUsuario.save(user);
		/*
		userEdit =  idUser.get();
		//userChange.setCompleteName(userChange.getCompleteName());
		//repositoryUsuario.save(userChange);
		//return userChange;
		
		checkMandatoryFields(userEdit);
		validadeUserForUpdate(userEdit);
		getRelations(userEdit);
		
		return repositoryUsuario.save(userEdit);
		*/
	}
	
	@Override
	public void deleteUser(Long id) {
		Optional<ModelUsuario> user = repositoryUsuario.findById(id);
		if(user == null) {
			throw new ExceptionBadRequest("Id inválido, não foi possivel excluir o usuario.");
		}
		repositoryUsuario.deleteById(id);
	}
	
	private void checkMandatoryFields(ModelUsuario user) {
		if (user == null) {
			throw new ExceptionBadRequest ("O usuário não pode ser nulo.");
		}
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("O email do usuario precisa ser informado.");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("A senha do usuario precsia ser informada.");
		}
		if(StringUtils.isEmpty(user.getUserName())) {
			throw new ExceptionBadRequest("O nome do usuario precisa ser informado.");
		}
	}
	
	private void validadeUser(ModelUsuario user) {
		if(!StringUtils.isEmpty(user.getUserName()) && repositoryUsuario.findByUserName(user.getUserName()) != null) {
			throw new ExceptionConflict("Nome de usuário existente.");
		}
		if(!StringUtils.isEmpty(user.getEmail()) && repositoryUsuario.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email existente.");
		}
	}
	private void validadeUserForUpdate(ModelUsuario user) {
		if(!StringUtils.isEmpty(user.getUserName()) && user.getId()!=null) {
			ModelUsuario userReturned = repositoryUsuario.findByUserName(user.getUserName());
			if (userReturned !=null && userReturned.getId() != null && !userReturned.getId().equals(user.getId())) {
				throw new ExceptionConflict("Nome de usuário existente.");
			}
		}
		if(!StringUtils.isEmpty(user.getEmail()) && user.getId()!=null) {
			ModelUsuario userReturned = repositoryUsuario.findByEmail(user.getEmail());
			if(userReturned != null && userReturned.getId() != null && !userReturned.getId().equals(user.getId())) {
				throw new ExceptionConflict("Email existente.");
			}
		}
	}
	
	private void getRelations(ModelUsuario modelUsuario) {
		
	}
	
	
}
