package br.ufba.siges.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
	@Size(min=2, max=100, message="O tamanho do campo nome tem que ser entre 2 e 20")
	private String nome;
	@Size(min=4, max=100, message="O tamanho do campo senha tem que ser entre 4 e 20")
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
