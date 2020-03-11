package com.pitang.Projeto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private UserDetailsServiceImpl userDetailsService;
	
		public WebSecurity(UserDetailsServiceImpl userDetailsService) {
			super();
			this.userDetailsService = userDetailsService;
		}
	
		@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}
		
		@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.headers().frameOptions().sameOrigin();
		http.csrf()
						.disable()
						.authorizeRequests()
						.antMatchers("/h2-console**").permitAll()
						.antMatchers("**").permitAll()
					.anyRequest().authenticated()
					.and()
					.httpBasic()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					;
		}
}
