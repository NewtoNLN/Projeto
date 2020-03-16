
package com.pitang.Projeto.service;

import java.util.List;

import com.pitang.Projeto.Model.ModelMensagem;

public interface ServiceMensagem {
	
	public List<ModelMensagem> listAllMessage();
	
	//public List<ModelMensagem> findAllMessageId(Long idSender);
	
	public List<ModelMensagem> findallMessageContact(Long idSender, Long idReciever);
	
	public ModelMensagem findMessageContact(Long id);
	
	public ModelMensagem sendMessage(ModelMensagem message);
	
	public void deleteMessage(Long id);
	
	public ModelMensagem findMessageById(Long id);
	
	
}
