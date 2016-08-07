package br.ufba.siges.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class CadastroSala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Significa que os valores de indice tabela serão criados automaticamente através de AUTO INCREMENT
	private Integer id_cadastrosala;
	
	
	
}
