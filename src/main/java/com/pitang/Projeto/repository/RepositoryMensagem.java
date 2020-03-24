
package com.pitang.Projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelMensagem;

import com.pitang.Projeto.dto.DtoMensagem;

public interface RepositoryMensagem extends JpaRepository<ModelMensagem, Long> {
	
	
	List<DtoMensagem> findByIdSenderAndIdReciever(Long idSender, Long idReciever);
	
	
	
	
}
