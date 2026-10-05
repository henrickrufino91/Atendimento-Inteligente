package br.com.portal.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portal.projeto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmailIgnoreCase(String email);

	List<Usuario> findAllByOrderByNomeAsc();

	boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

	boolean existsByEmailIgnoreCase(String email);
}
