package com.pitang.Projeto.security;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pitang.Projeto.Model.ModelUsuario;
import com.pitang.Projeto.repository.RepositoryUsuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private RepositoryUsuario repositoryUsuario;
	
	public UserDetailsServiceImpl (RepositoryUsuario repositoryUsuario) {
		super();
		this.repositoryUsuario = repositoryUsuario;
	}

		@Override
	public UserDetails loadUserByUsername (String userName) {
			ModelUsuario applicationUser = repositoryUsuario.findByUserName(userName);
			if (applicationUser == null) {
				throw new UsernameNotFoundException(userName);
			}
			return new User("Newton","password",true,true,true,true,emptyList());
		}
}
