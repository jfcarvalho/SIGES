package br.ufba.siges.model;

public enum Nivel {
	ADMINISTRADOR("Administrador"),
	MODERADOR("Moderador"),
	USUARIO_COMUN("Usuário Padrão");
	
	private String nivel;


 Nivel(String nivel)
{
	this.nivel = nivel;
}

public String getNivel()
{
	return nivel;
}

public void setNivel(String nivel)
{
	this.nivel = nivel;
}


}
