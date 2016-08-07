package br.ufba.siges.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
	private Nivel nivel_acesso;
}
