package com.api.springboot.desafio.services;

import com.api.springboot.desafio.models.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
