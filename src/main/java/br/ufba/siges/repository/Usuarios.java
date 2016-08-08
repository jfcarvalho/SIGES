package br.ufba.siges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.siges.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer>{
	List<Usuario> findByNomeContaining(String nome);

	
}