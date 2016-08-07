package br.ufba.siges.model;

public enum TipoDeSala {
	SALA_DE_AULA("Sala de Aula"),
	LABORATORIO("Laboratorio"),
	AUDITORIO("Auditorio");
	
	private String tipo;


 TipoDeSala(String tipo)
{
	this.tipo = tipo;
}

public String getTipo()
{
	return tipo;
}

public void setTipo(String tipo)
{
	this.tipo = tipo;
}


}

