package br.ufba.siges.model;

public enum TipoDeSala {
	SALA_DE_AULA("Sala de Aula"),
	LABORATORIO("Laboratorio"),
	AUDITORIO("Auditorio");
	
	private String descricao;


 TipoDeSala(String descricao)
{
	this.descricao = descricao;
}

public String getDescricao()
{
	return descricao;
}

public void setDescricao(String descricao)
{
	this.descricao= descricao;
}


}

