
package com.pitang.Projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelMensagem;

public interface RepositoryMensagem extends JpaRepository<ModelMensagem, Long> {
	
	
	
	Optional<ModelMensagem> findById(Long id);
	
	//Optional<ModelMensagem> findByUserSenderAndUserReciever(Long userSender, Long userReciever);
	
	
	
}
