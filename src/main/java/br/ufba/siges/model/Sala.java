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
	private Integer numeroSala;
	private String instituto;
	private String departamento;
	private TipoDeSala tipoSala;
	private boolean situacao;
	private Integer capacidade;
	
	
	
	
	public Integer getId_sala()
	{
		return this.id_sala;
	}
	
	public void setId_sala(Integer id_sala)
	{
		this.id_sala = id_sala;
	}
	
	public Integer getnumeroSala()
	{
		return this.numeroSala;
	}
	
	public void setnumeroSala(Integer numeroSala)
	{
		this.numeroSala = numeroSala;
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
	
	public TipoDeSala getTipoSala()
	{
		return this.tipoSala;
	}
	
	public void setTipoSala(TipoDeSala tipoSala)
	{
		this.tipoSala = tipoSala;
	}
	
	public boolean getSituacao()
	{
		return this.situacao;
	}
	
	public void setSituacao(boolean situacao)
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
