
package com.pitang.Projeto.controller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoMensagem;
import com.pitang.Projeto.dto.DtoUsuario;
import com.pitang.Projeto.mapper.ModelMapperComponent;
import com.pitang.Projeto.service.ServiceMensagem;
import com.pitang.Projeto.service.ServiceUsuario;

@RestController
public class ControllerMensagem {
	
	private ServiceMensagem serviceMensagem;
	
	
	public ControllerMensagem (ServiceMensagem serviceMensagem) {
		super();
		this.serviceMensagem = serviceMensagem;
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DtoMensagem>> listAllMessage() {
		List<ModelMensagem> msg = serviceMensagem.listAllMessage();
		
		if(msg.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<DtoMensagem> dtoMensagem = ModelMapperComponent.modelMapper.map(msg, new TypeToken<List<DtoMensagem>>() {}.getType());
		return new ResponseEntity<>(dtoMensagem, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/message/{idSender}/{idReciever}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DtoMensagem>> listAllMessageContact(@PathVariable("idSender") Long idSender, @PathVariable("idReciever") Long idReciever){
		List<DtoMensagem> messageSender = serviceMensagem.findallMessageContact(idSender, idReciever);
		List<DtoMensagem> messageReciever = serviceMensagem.findallMessageContact(idReciever, idSender);
		messageSender.addAll(messageReciever);
		
		if(messageSender.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		//List<DtoMensagem> dtoMensagem = ModelMapperComponent.modelMapper.map(messageSender, new TypeToken<List<DtoMensagem>>() {}.getType());
		return new ResponseEntity<>(messageSender, HttpStatus.OK);
	}
	
	@RequestMapping (value = "/message/{sender}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<DtoMensagem> sendMessage(@PathVariable("sender") Long sender ,@RequestBody DtoMensagem dtoMensagem) {
		ModelUsuario msgSender = serviceMensagem.findUserByMessage(sender);
		ModelMensagem msg = ModelMapperComponent.modelMapper.map(dtoMensagem, new TypeToken<ModelMensagem>() {}.getType());
		msg.setIdSender(msgSender);
		serviceMensagem.sendMessage(msg);
		if (dtoMensagem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dtoMensagem = ModelMapperComponent.modelMapper.map(msg, new TypeToken<DtoMensagem>() {}.getType());
		
		return new ResponseEntity<>(dtoMensagem, HttpStatus.OK);
	}
	@RequestMapping (value = "/message/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<DtoMensagem> deleteMessage(@PathVariable("id") Long id) {
		serviceMensagem.deleteMessage(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	

}
