
package com.pitang.Projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelUsuario;

public interface RepositoryContatos extends JpaRepository<ModelContatos, Long> {
	
	List<ModelContatos> findUserListById(Long id);
	
	//ModelContatos findContactBySenderAndReciever(ModelUsuario userSender, ModelUsuario idReciever);
	
	

}
