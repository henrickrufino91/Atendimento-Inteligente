package br.com.portal.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	List<Profissional> findByAtivoTrueOrderByNome();
}
