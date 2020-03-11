
package com.pitang.Projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelUsuario;

public interface RepositoryContatos extends JpaRepository<ModelContatos, Long> {
	
	Optional<ModelContatos> findById(Long id);
	
	ModelContatos findContactBySenderAndReciever(ModelUsuario userSender, ModelUsuario userReciever);
	
	

}
