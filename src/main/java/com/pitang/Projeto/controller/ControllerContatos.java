package com.pitang.Projeto.controller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.dto.DtoContatos;
import com.pitang.Projeto.mapper.ModelMapperComponent;
import com.pitang.Projeto.service.ServiceContatos;

public class ControllerContatos {
	/*
	private ServiceContatos serviceContatos;
	
	public ControllerContatos (ServiceContatos serviceContatos) {
		super();
		this.serviceContatos = serviceContatos;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <List<DtoContatos>> listContatosall(){
		List<ModelContatos> modelContatos = serviceContatos.listcontact();
		
		if (modelContatos.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<DtoContatos> dtoContatos = ModelMapperComponent.modelMapper.map(modelContatos, new TypeToken<List<DtoContatos>>() {}.getType());
		
		return new ResponseEntity<>(dtoContatos,HttpStatus.OK);
	}
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <List<DtoContatos>> listContatosUsuario(@PathVariable("id") Long id ){
	List<ModelContatos> modelContatos = serviceContatos.userContacts(id);
	
	if(modelContatos.size() == 0) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	List<DtoContatos> dtoContact = ModelMapperComponent.modelMapper.map(modelContatos, new TypeToken<List<DtoContatos>>() {}.getType());
	}
	@RequestMapping(value = "/user/{id}/contact/{idcontact}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity <ModelContatos> deleteContact(@PathVariable ("iduser") Long iduser, @PathVariable("idcontato") Long idcontato) {
		if((iduser == null) || (idcontato == null)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	*/
}

