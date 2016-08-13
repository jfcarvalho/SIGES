package br.ufba.siges.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Significa que os valores de indice tabela serão criados automaticamente através de AUTO INCREMENT
	private Integer id_sala;
	private String numero;
	private String instituto;
	private String departamento;
	private TipoDeSala tipo;
	private Situacao situacao;
	private Integer capacidade;
	
	
	
	
	public Integer getId_sala()
	{
		return this.id_sala;
	}
	
	public void setId_sala(Integer id_sala)
	{
		this.id_sala = id_sala;
	}
	
	public String getNumero()
	{
		return this.numero;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	public String getInstituto()
	{
		return this.instituto;
	}
	
	public void setInstituto(String instituto)
	{
		this.instituto = instituto;
	}
	
	public String getDepartamento()
	{
		return this.departamento;
	}
	
	public void setDepartamento(String departamento)
	{
		this.departamento = departamento;
	}
	
	public TipoDeSala getTipo()
	{
		return this.tipo;
	}
	
	public void setTipo(TipoDeSala tipo)
	{
		this.tipo = tipo;
	}
	
	public Situacao getSituacao()
	{
		return this.situacao;
	}
	
	public void setSituacao(Situacao situacao)
	{
		this.situacao = situacao;
	}
	
	public Integer getCapacidade()
	{
		return this.capacidade;
	}
	
	public void setCapacidade(Integer capacidade)
	{
		this.capacidade = capacidade;
	}

	
}
