package br.com.portal.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.Prescricao;

public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {
	List<Prescricao> findByAtendimentoIdOrderByCriadoEmDesc(Long atendimentoId);
}
