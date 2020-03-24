
package com.pitang.Projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.Projeto.Exceptions.ExceptionBadRequest;
import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoMensagem;
import com.pitang.Projeto.repository.RepositoryMensagem;
import com.pitang.Projeto.repository.RepositoryUsuario;
import com.pitang.Projeto.service.ServiceMensagem;

@Service
public class ServiceMensagemImpl implements ServiceMensagem {
	
	@Autowired 
	private RepositoryMensagem repositoryMensagem;
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;

	@Override
	public List<ModelMensagem> listAllMessage() {
		return repositoryMensagem.findAll();
	}
	@Override
	public ModelUsuario findUserByMessage(Long id) {
		Optional<ModelUsuario> user = repositoryUsuario.findById(id);
		return user.get();
	}

	

	@Override
	public List<DtoMensagem> findallMessageContact(Long idSender, Long idReciever) {
		
		ModelUsuario validadeSender = repositoryUsuario.findById(idSender).get();
		ModelUsuario validadeReciever = repositoryUsuario.findById(idReciever).get();
		if (validadeSender == null || validadeReciever == null) {
			throw new ExceptionBadRequest("Usuário não encontrado");
		}
		
		return repositoryMensagem.findByIdSenderAndIdReciever(idSender, idReciever);
	
	}

	@Override
	public ModelMensagem findMessageContact(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelMensagem sendMessage(ModelMensagem message) {
		return repositoryMensagem.save(message);
	}

	@Override
	public void deleteMessage(Long id) {
		if (id == null || id == 0 ) {
			throw new ExceptionBadRequest("Id inválido");
		}
		
		repositoryMensagem.deleteById(id);
	}
	
	@Override
	public ModelMensagem findMessageById(Long id) {
		Optional<ModelMensagem> message = repositoryMensagem.findById(id);
		if(!message.isPresent()) {
			throw new ExceptionBadRequest("Usuário não encontrado");
		}
		return message.get();
	}

	
	

}
