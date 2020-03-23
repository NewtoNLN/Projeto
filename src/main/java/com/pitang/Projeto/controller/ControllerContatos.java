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
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoContatos;
import com.pitang.Projeto.mapper.ModelMapperComponent;
import com.pitang.Projeto.service.ServiceContatos;

@RestController	
public class ControllerContatos {
	
	private ServiceContatos serviceContatos;
	
	public ControllerContatos (ServiceContatos serviceContatos) {
		super();
		this.serviceContatos = serviceContatos;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <List<DtoContatos>> listContact(){
		List<ModelContatos> modelContatos = serviceContatos.listContact();
		
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
	List<DtoContatos> dtoContatos = ModelMapperComponent.modelMapper.map(modelContatos, new TypeToken<List<DtoContatos>>() {}.getType());
	return new ResponseEntity<>(dtoContatos, HttpStatus.OK);
	}
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity <DtoContatos> removeContact(@PathVariable("id")Long id) {
		serviceContatos.deleteContact(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/contact/{id}/{idcontact}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<DtoContatos> updateContact(@PathVariable("id") Long id, @PathVariable("idcontact") Long idcontact, @RequestBody DtoContatos dtoContatos) {
	ModelUsuario user = serviceContatos.findUserByContact(id);
	ModelContatos contact = ModelMapperComponent.modelMapper.map(dtoContatos, new TypeToken<ModelContatos>() {}.getType());
	contact.setUserSender(user);
	serviceContatos.updateContact(contact);
	if(dtoContatos == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	dtoContatos = ModelMapperComponent.modelMapper.map(contact, new TypeToken<DtoContatos>() {}.getType());
	return new ResponseEntity<>(dtoContatos, HttpStatus.OK);
	}
	
	
}

