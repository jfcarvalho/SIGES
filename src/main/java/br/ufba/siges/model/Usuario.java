package br.ufba.siges.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
	@Pattern(regexp = "[a-z-A-Z-\\s]*" ,message="So é permitido caracteres no campo Nome")
	@Size(min=2, max=100, message="O tamanho do campo nome tem que ser entre 2 e 20")
	private String nome;
	@Size(min=4, max=100, message="O tamanho do campo senha tem que ser entre 4 e 20")
	private String password;
	private Nivel nivel_acesso;
	@Email(message="Formato de email inválido")
	private String email;
	private String endereco;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	public Date data_nascimento;
	
	public Nivel getNivel_acesso()
	{
		return this.nivel_acesso;
	}
	
	public void setNivel_acesso(Nivel nivel_acesso)
	{
		this.nivel_acesso = nivel_acesso;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEndereco()
	{
		return this.endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
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
	
	public Date getData_nascimento()
	{
		return this.data_nascimento;
	}
	
	public void setData_nascimento(Date data_nascimento)
	{
		this.data_nascimento = data_nascimento;
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
