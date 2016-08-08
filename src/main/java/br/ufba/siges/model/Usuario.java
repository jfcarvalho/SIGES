package br.ufba.siges.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
	private String nome;
	private String password;
	private Nivel nivel_acesso;
	
	public Nivel getNivel_acesso()
	{
		return this.nivel_acesso;
	}
	
	public void setNivel_acesso(Nivel nivel_acesso)
	{
		this.nivel_acesso = nivel_acesso;
	}
	
	public Integer getId_usuario()
	{
		return this.id_usuario;
	}
	
	public void setId_usuario(Integer id_usuario)
	{
		this.id_usuario = id_usuario;
	}
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

}
