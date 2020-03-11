
package com.pitang.Projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.pitang.Projeto.Exceptions.ExceptionBadRequest;
import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.repository.RepositoryContatos;
import com.pitang.Projeto.repository.RepositoryUsuario;
import com.pitang.Projeto.service.ServiceContatos;

public class ServiceContatosImpl implements ServiceContatos {

	@Autowired
	private RepositoryContatos repositoryContatos;
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	@Override
	public List<ModelContatos> listcontact() {
		if(repositoryContatos.findAll().size() == 0) {
			return null;
		}
		return repositoryContatos.findAll();
	}

	@Override
	public ModelContatos findContactById(Long id) {
		Optional<ModelContatos> contact = repositoryContatos.findById(id);
		if(!contact.isPresent()) {
			throw new ExceptionBadRequest("Usuário não encontrado");
		}
		
		return contact.get();
	}

	@Override
	public void deleteContact(Long id) {
		Optional<ModelContatos> contact = repositoryContatos.findById(id);
		if(contact == null) {
			throw new ExceptionBadRequest("Id inválido, não foi possivel excluir o usuário");
		}
	}

	@Override
	public ModelContatos addContact(ModelContatos contact) {
		checkContact(contact);
		validadeContact(contact);
		getRelations(contact);
		return repositoryContatos.save(contact);
		
	}

	@Override
	public List<ModelContatos> userContacts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	private void checkContact(ModelContatos contact) {
		if (contact == null) {
			throw new ExceptionBadRequest("Contato não pode ser nulo");
		}
		
		if(StringUtils.isEmpty(contact.getContactName())) {
			throw new ExceptionBadRequest("O nome do contato está vazio.");
		}
		if(StringUtils.isEmpty(contact.getUserSender())) {
			throw new ExceptionBadRequest("O id do dono do contato está vazio.");
		}
		if(StringUtils.isEmpty(contact.getUserReciever())) {
			throw new ExceptionBadRequest("O id do contato está vazio.");
		}
	}
	
	private void validateContact(ModelContatos contact) {
		Optional<ModelUsuario> usercontactDB = repositoryUsuario.findById(contact.getId());
		ModelContatos contactDB = repositoryContatos.findContactBySenderAndReciever(contact.getUserSender(), contact.getUserReciever());
		
		if(!usercontactDB.isPresent()) {
			throw new ExceptionBadRequest("Id inválido ou contato inexistente");
		}
		if(contactDB != null) {
			throw new ExceptionBadRequest("Id inválido ou contato inexistente");
		}
	}
	private void getRelations(ModelContatos modelContatos) {
		
	}
	
	/*
	
	@Autowired
	//private ServiceMensagemImpl serviceMensagemImpl;
	
	@Override
	public List<ModelContatos> listcontact(){
		return repositoryContatos.findAll();
	}
	
	@Override
	public ModelContatos addContact(ModelContatos contact) {
		checkContact(contact);
		validateContact(contact);
		return repositoryContatos.save(contact);
	}
	
	@Override
	public ModelUsuario findUserByContact(Long id) {
		Optional<ModelUsuario> user = repositoryUsuario.findById(id);
		return user.get();
	}
	
	@Override
	public List<ModelContatos> userContacts(Long id){
		ModelUsuario userValido = repositoryUsuario.findById(id).get();
		if(userValido == null) {
			throw new ExceptionBadRequest("Usuário não encontrado");
		}
		
		return repositoryContatos.findContactByUserId(id);
	}
	
	@Override
	public String deleteContact(Long id) {
		if (id == null || id == 0 ) {
			throw new ExceptionBadRequest("Id inválido");
		}
		
		ModelContatos contactDB = repositoryContatos.findContactByUserAndContact(userSender, userReciever);
		if (contactDB == null) {
			throw new ExceptionBadRequest("Contato não encontrado");
		}
		repositoryContatos.deleteById(contactDB.getId());
		
		return "contato deletado com sucesso" ;
	}
	
	
	
	
	*/
	
}