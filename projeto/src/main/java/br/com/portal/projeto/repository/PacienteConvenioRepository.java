package br.com.portal.projeto.repository;
import br.com.portal.projeto.entity.PacienteConvenio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PacienteConvenioRepository extends JpaRepository<PacienteConvenio,Long>{
 List<PacienteConvenio> findByPacienteIdOrderByConvenioNomeAsc(Long pacienteId);
 List<PacienteConvenio> findByPacienteIdAndAtivoTrueOrderByConvenioNomeAsc(Long pacienteId);
}
