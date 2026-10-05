package br.com.portal.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	Optional<Perfil> findByCodigo(String codigo);

	List<Perfil> findAllByOrderByNomeAsc();
}
