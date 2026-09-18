package br.com.portal.projeto.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.ClassificacaoRisco;
import br.com.portal.projeto.entity.NivelRisco;

public interface ClassificacaoRiscoRepository extends JpaRepository<ClassificacaoRisco, Long> {
	Optional<ClassificacaoRisco> findBySenhaId(Long senhaId);

	long countByNivelFinalAndClassificadoEmBetween(NivelRisco nivel, LocalDateTime inicio, LocalDateTime fim);

	List<ClassificacaoRisco> findTop20ByOrderByClassificadoEmDesc();
}
