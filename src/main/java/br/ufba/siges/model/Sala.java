package br.ufba.siges.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity

public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Significa que os valores de indice tabela serão criados automaticamente através de AUTO INCREMENT
	private Integer id_sala;
	@Size(min=1, max=100, message="O tamanho do campo número da sala tem que ser entre 1 e 20")
	@Pattern(regexp = "[0-9]*",message="So é permitido números no campo Número de sala")
	private String numero;
	
	@Size(min=1, max=100, message="O tamanho do campo instituto tem que ser entre 1 e 50")
	private String instituto;
	@Size(min=2, max=50, message="O tamanho do campo departamento tem que ser entre 2 e 50")
	
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
