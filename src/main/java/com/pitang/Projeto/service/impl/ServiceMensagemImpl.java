
package com.pitang.Projeto.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.repository.RepositoryMensagem;
import com.pitang.Projeto.service.ServiceMensagem;

public class ServiceMensagemImpl implements ServiceMensagem {
	
	@Autowired 
	private RepositoryMensagem repositoryMensagem;
	
	@Autowired
	private ServiceContatosImpl serviceContatosImpl;

	@Override
	public List<ModelMensagem> listAllMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModelMensagem> findAllMessageId(Long idSender) {
		// TODO Auto-generated method stub
		return null;
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
	public ModelMensagem sendMessage(ModelMensagem modelMensagem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelMensagem deleteMessage(ModelMensagem modelMensagem) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
