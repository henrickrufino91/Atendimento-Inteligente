package br.com.portal.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
	List<Atendimento> findTop10ByOrderByInicioDesc();

	long countByFimIsNull();
}
