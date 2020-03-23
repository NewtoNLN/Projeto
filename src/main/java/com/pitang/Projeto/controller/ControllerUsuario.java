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

import com.pitang.Projeto.Exceptions.ExceptionBadRequest;
import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoContatos;
import com.pitang.Projeto.dto.DtoUsuario;
import com.pitang.Projeto.mapper.ModelMapperComponent;
import com.pitang.Projeto.service.ServiceContatos;
import com.pitang.Projeto.service.ServiceUsuario;

@RequestMapping(value = "/user")
@RestController
public class ControllerUsuario {
		private ServiceUsuario serviceUsuario;
		private ServiceContatos serviceContatos;
		
		public ControllerUsuario(ServiceUsuario serviceUsuario, ServiceContatos serviceContatos) {
			super();
			this.serviceUsuario = serviceUsuario;
			this.serviceContatos = serviceContatos;
			
		}
		
		@RequestMapping(method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<DtoUsuario>> listUsers() {
			List<ModelUsuario> users = serviceUsuario.listUsers();
			
			if(users.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			List<DtoUsuario> dtoUsuarios = ModelMapperComponent.modelMapper.map(users, new TypeToken<List<DtoUsuario>>() {}.getType());
			ModelMapperComponent.modelMapper.validate();
			return new ResponseEntity<>(dtoUsuarios, HttpStatus.OK);
			
			
		}
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity <DtoUsuario> listUserById(@PathVariable("id") Long id ) {
			ModelUsuario user = serviceUsuario.findUserById(id);
			if(user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			DtoUsuario dtoUsuario = ModelMapperComponent.modelMapper.map(user, new TypeToken<DtoUsuario>() {}.getType());
			
			return new ResponseEntity<>(dtoUsuario, HttpStatus.OK);
		}
		
		
		@RequestMapping(method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<DtoUsuario> addUser(@RequestBody DtoUsuario dtoUsuario) {
			if (dtoUsuario == null) {
				throw new ExceptionBadRequest("Não é possivel salvar um usuário nulo.");
			}
			
			ModelUsuario modelUsuario = ModelMapperComponent.modelMapper.map(dtoUsuario, new TypeToken<ModelUsuario>() {}.getType());
			ModelMapperComponent.modelMapper.validate();
			serviceUsuario.addUser(modelUsuario);
			dtoUsuario = ModelMapperComponent.modelMapper.map(modelUsuario, new TypeToken<DtoUsuario>() {}.getType());
			ModelMapperComponent.modelMapper.validate();
			
			return new ResponseEntity<>(dtoUsuario,HttpStatus.CREATED);
			
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		@ResponseBody
		public ResponseEntity<DtoUsuario> updateUser(@PathVariable("id") Long id, @RequestBody DtoUsuario dtoUsuario) {
			if (id == null || dtoUsuario == null) {
				throw new ExceptionBadRequest("Dados informados são nulos,");
			}
			ModelUsuario user = ModelMapperComponent.modelMapper.map(dtoUsuario, new TypeToken<ModelUsuario>() {}.getType());
			serviceUsuario.updateUser(user);
			dtoUsuario = ModelMapperComponent.modelMapper.map(user, new TypeToken<DtoUsuario>() {}.getType());
			return new ResponseEntity<>(dtoUsuario, HttpStatus.OK);
		}
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ResponseBody
		public ResponseEntity<DtoUsuario> removeUser(@PathVariable("id") Long id){
			serviceUsuario.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@RequestMapping(value = "/{id}/contact", method  =RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<DtoContatos> addContact(@PathVariable("id") Long id,@RequestBody DtoContatos dtoContatos) {
		ModelUsuario user = serviceContatos.findUserByContact(id);
		ModelContatos contact = ModelMapperComponent.modelMapper.map(dtoContatos, new TypeToken<ModelContatos>() {}.getType());
		contact.setUserSender(user);
		serviceContatos.addContact(contact);
			if(dtoContatos == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		dtoContatos = ModelMapperComponent.modelMapper.map(contact, new TypeToken<DtoContatos>() {}.getType());	
		return new ResponseEntity<>(dtoContatos, HttpStatus.CREATED);
		}
		
}
