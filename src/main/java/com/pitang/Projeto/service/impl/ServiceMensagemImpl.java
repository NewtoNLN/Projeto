
package com.pitang.Projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.Projeto.Exceptions.ExceptionBadRequest;
import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.repository.RepositoryMensagem;
import com.pitang.Projeto.service.ServiceMensagem;

@Service
public class ServiceMensagemImpl implements ServiceMensagem {
	
	@Autowired 
	private RepositoryMensagem repositoryMensagem;
	
	@Autowired
	private ServiceContatosImpl serviceContatosImpl;

	@Override
	public List<ModelMensagem> listAllMessage() {
		if(repositoryMensagem.findAll().size()==0) {
			return null;
		}
		return repositoryMensagem.findAll();
	}

	

	@Override
	public List<ModelMensagem> findallMessageContact(Long idSender, Long idReciever) {
		// TODO Auto-generated method stub
		return null;
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
		
		Optional<ModelMensagem> message = repositoryMensagem.findById(id);
		if (message == null) {
			throw new ExceptionBadRequest("Mensagem não encontrada");
		}
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
