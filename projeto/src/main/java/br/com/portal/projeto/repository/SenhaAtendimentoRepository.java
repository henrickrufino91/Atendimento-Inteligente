package br.com.portal.projeto.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.portal.projeto.entity.SenhaAtendimento;
import br.com.portal.projeto.entity.StatusSenha;
import br.com.portal.projeto.entity.TipoSenha;

public interface SenhaAtendimentoRepository extends JpaRepository<SenhaAtendimento, Long> {
	List<SenhaAtendimento> findByDataReferenciaOrderByEmitidaEmAsc(LocalDate data);

	long countByDataReferenciaAndStatus(LocalDate data, StatusSenha status);

	List<SenhaAtendimento> findByDataReferenciaAndStatusOrderByEmitidaEmAsc(LocalDate data, StatusSenha status);

	Optional<SenhaAtendimento> findByAtendimentoId(Long atendimentoId);

	@Query("select coalesce(max(s.numero),0) from SenhaAtendimento s where s.dataReferencia=:data and s.tipo=:tipo")
	Integer maiorNumero(@Param("data") LocalDate data, @Param("tipo") TipoSenha tipo);
}
