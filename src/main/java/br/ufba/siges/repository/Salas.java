package br.ufba.siges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.siges.model.Sala;
import br.ufba.siges.model.Usuario;

public interface Salas extends JpaRepository<Sala, Integer>{
	List<Sala> findByNumero(String numero);
	List<Sala> findByInstitutoContaining(String Instituto);
	
}