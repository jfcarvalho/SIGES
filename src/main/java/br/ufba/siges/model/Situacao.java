package br.ufba.siges.model;

public enum Situacao {
	Disponivel("Disponivel"),
	Manutencao("Manutencao"),
	Interditado("Interditado");
	
	private String descricao;


 Situacao(String descricao)
{
	this.descricao= descricao;
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

