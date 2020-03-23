
package com.pitang.Projeto.service;

import java.util.List;

import com.pitang.Projeto.Model.ModelContatos;
import com.pitang.Projeto.Model.ModelUsuario;

public interface ServiceContatos {
	
	public List<ModelContatos> listContact();
	
	public ModelUsuario findContactById(Long id);
	
	public void deleteContact(Long id);
	
	public ModelContatos addContact(ModelContatos contact);
	
	public List<ModelContatos> userContacts(Long id);
	
	public ModelUsuario findUserByContact(Long id);
	
	public ModelContatos updateContact(ModelContatos contact);

}
