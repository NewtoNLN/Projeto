package com.pitang.Projeto.mapper;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelMensagem;
import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.dto.DtoContatos;
import com.pitang.Projeto.dto.DtoMensagem;
import com.pitang.Projeto.dto.DtoUsuario;

@Component
public class ModelMapperComponent {
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	@PostConstruct
	private void configureMapper() {
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	modelMapper.addMappings(
		new PropertyMap<ModelUsuario, DtoUsuario>(){
			@Override
			protected void configure() {
			map().setId(source.getId());
			map().setEmail(source.getEmail());
			map().setUserName(source.getUserName());
			map().setCompleteName(source.getCompleteName());
			map().setPassword(null);
			
			
		}
		
				
	});
	
	modelMapper.addMappings(
		new PropertyMap<DtoUsuario, ModelUsuario>(){
			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setUserName(source.getUserName());
				map().setCompleteName(source.getCompleteName());
				map().setEmail(source.getEmail());
				map().setPassword(source.getPassword());
				
			}
			
			
		
		}	);
	
	modelMapper.addMappings(
		new PropertyMap<ModelContatos, DtoContatos>(){
			@Override
			protected void configure() {
			map().setId(source.getId());
			map().setContactName(source.getContactName());
			map().setUserSender(source.getUserSender().getId());
			map().setUserReciever(source.getUserReciever().getId());
				
			}
		}
			
			);
	modelMapper.addMappings(
			new PropertyMap<DtoContatos, ModelContatos>(){
				@Override
				protected void configure() {
					map().setId(source.getId());
					map().setContactName(source.getContactName());
					map().getUserReciever().setId(source.getUserReciever());
					map().getUserSender().setId(source.getUserSender());
					
				}		
			}	);
	/*
	modelMapper.addMappings(
			new PropertyMap<DtoMensagem, ModelMensagem>() {
				@Override
				protected void configure() {
					map().setMessage(source.getMessage());
				}
	});
	
	modelMapper.addMappings(
			new PropertyMap<ModelMensagem, DtoMensagem>() {
				@Override
				protected void configure() {
					map().setId(source.getId());
					map().setMessage(source.getMessage);
					map().setUserSender(source.getUserSender());
					map().setUserReciever(source.getUserReciever());
				}
			}
			);
	
	*/
	}
	

}
