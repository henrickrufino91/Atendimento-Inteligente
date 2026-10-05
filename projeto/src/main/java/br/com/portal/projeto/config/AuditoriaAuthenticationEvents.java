package br.com.portal.projeto.config;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.portal.projeto.entity.TipoEventoAuditoria;
import br.com.portal.projeto.service.AuditoriaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuditoriaAuthenticationEvents {
	private final AuditoriaService auditoria;
	private final HttpServletRequest request;

	@EventListener
	public void sucesso(AuthenticationSuccessEvent e) {
		reg(e.getAuthentication().getName(), TipoEventoAuditoria.LOGIN_SUCESSO, 200, "Login realizado com sucesso");
	}

	@EventListener
	public void falha(AbstractAuthenticationFailureEvent e) {
		reg(e.getAuthentication() == null ? "desconhecido" : e.getAuthentication().getName(),
				TipoEventoAuditoria.LOGIN_FALHA, 401, "Falha de autenticação");
	}

	@EventListener
	public void logout(LogoutSuccessEvent e) {
		Authentication a = e.getAuthentication();
		reg(a == null ? "desconhecido" : a.getName(), TipoEventoAuditoria.LOGOUT, 200, "Logout realizado");
	}

	private void reg(String u, TipoEventoAuditoria t, int status, String d) {
		auditoria.registrar(u, t, "AUTENTICACAO", null, "POST", t == TipoEventoAuditoria.LOGOUT ? "/logout" : "/login",
				request.getRemoteAddr(), request.getHeader("User-Agent"), status, d);
	}
}
