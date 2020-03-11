
package com.pitang.Projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.service.ServiceMensagem;
import com.pitang.Projeto.service.ServiceUsuario;

public class ControllerMensagem {
	
	private ServiceMensagem serviceMensagem;
	
	private ServiceUsuario serviceUsuario;
	
	public ControllerMensagem (ServiceMensagem serviceMensagem, ServiceUsuario serviceUsuario) {
		super();
		this.serviceMensagem = serviceMensagem;
		this.serviceUsuario = serviceUsuario;
	}
	
	@RequestMapping(value = "/mensagem", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ModelMensagem>> listAllMessage() {
		List<ModelMensagem> msg = serviceMensagem.listAllMessage();
		
		if(msg.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	

}
