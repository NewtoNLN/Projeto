
package com.pitang.Projeto.service;

import java.util.List;

import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoMensagem;

public interface ServiceMensagem {
	
	public List<ModelMensagem> listAllMessage();
	
	//public List<ModelMensagem> findAllMessageId(Long idSender);
	
	public List<DtoMensagem> findallMessageContact(Long idSender, Long idReciever);
	
	public ModelUsuario findUserByMessage(Long id);
	
	public ModelMensagem findMessageContact(Long id);
	
	public ModelMensagem sendMessage(ModelMensagem message);
	
	public void deleteMessage(Long id);
	
	public ModelMensagem findMessageById(Long id);
	
	
}
