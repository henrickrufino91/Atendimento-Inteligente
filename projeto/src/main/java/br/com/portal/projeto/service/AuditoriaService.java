package br.com.portal.projeto.service;

import br.com.portal.projeto.entity.*;
import br.com.portal.projeto.repository.AuditoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import java.time.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriaService {
	private final AuditoriaRepository repo;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void registrar(String usuario, TipoEventoAuditoria tipo, String entidade, String registroId, String metodo,
			String rota, String ip, String userAgent, int status, String detalhes) {
		try {
			repo.save(Auditoria.builder().usuario(corta(usuario, 150)).tipoEvento(tipo).entidade(corta(entidade, 80))
					.registroId(corta(registroId, 80)).metodo(corta(metodo, 10)).rota(corta(rota, 500))
					.ip(corta(ip, 64)).userAgent(corta(userAgent, 500)).statusHttp(status)
					.detalhes(corta(detalhes, 1000)).build());
		} catch (Exception ignored) {
		}
	}

	@Transactional(readOnly = true)
	public List<Auditoria> listar(LocalDate inicio, LocalDate fim, String usuario, TipoEventoAuditoria tipo) {
		return repo.filtrar(inicio == null ? null : inicio.atStartOfDay(),
				fim == null ? null : fim.plusDays(1).atStartOfDay(), usuario, tipo);
	}

	private static String corta(String s, int n) {
		return s == null ? null : (s.length() <= n ? s : s.substring(0, n));
	}
}
