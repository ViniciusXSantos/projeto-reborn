package com.example.agencia_viagens.repository.filter;

import lombok.Data;

@Data
public class UsuarioFilter {
	
	private String nome;
	private String email;
	private String telefone;
	private Boolean ativo;

}
