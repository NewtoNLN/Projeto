
package com.pitang.Projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelContatos;

public interface RepositoryContatos extends JpaRepository<ModelContatos, Long> {
	
	//List<ModelContatos> findUserListById(Long id);
	List<ModelContatos> findByUserSenderId(Long id);
	
	//ModelContatos findContactBySenderAndReciever(ModelUsuario userSender, ModelUsuario idReciever);
	
	

}
