package com.pitang.Projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitang.Projeto.Model.ModelUsuario;

public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long> {
	
	ModelUsuario findByUserName(String userName);
	ModelUsuario findByEmail(String email);
	Optional<ModelUsuario> findById(Long id);
}
