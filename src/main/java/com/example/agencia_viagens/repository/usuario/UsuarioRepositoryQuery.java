package com.example.agencia_viagens.repository.usuario;



import com.example.agencia_viagens.model.Usuario;
import com.example.agencia_viagens.repository.filter.UsuarioFilter;

import java.util.List;

public interface UsuarioRepositoryQuery {
	
	public List<Usuario> filtrar(UsuarioFilter usuarioFilter);

}