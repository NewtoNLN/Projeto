
package com.pitang.Projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelContatos;

public interface RepositoryContatos extends JpaRepository<ModelContatos, Long> {
	
	List<ModelContatos> findByUserSenderId(Long id);
	
	
	

}
