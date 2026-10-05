package br.com.portal.projeto.repository;
import br.com.portal.projeto.entity.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ConvenioRepository extends JpaRepository<Convenio,Long>{ List<Convenio> findAllByOrderByNomeAsc(); List<Convenio> findByAtivoTrueOrderByNomeAsc(); }
