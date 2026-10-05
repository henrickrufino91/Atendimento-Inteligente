package br.com.portal.projeto.config;
import br.com.portal.projeto.entity.TipoEventoAuditoria;
import br.com.portal.projeto.service.AuditoriaService;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.*;
@Component @RequiredArgsConstructor
public class AuditoriaInterceptor implements HandlerInterceptor {
 private final AuditoriaService auditoria;
 @Override public void afterCompletion(HttpServletRequest req,HttpServletResponse res,Object handler,Exception ex){
  String m=req.getMethod(); if(!(m.equals("POST")||m.equals("PUT")||m.equals("PATCH")||m.equals("DELETE")))return;
  String uri=req.getRequestURI(); if(uri.equals("/login")||uri.equals("/logout")||uri.startsWith("/css/")||uri.startsWith("/js/"))return;
  Authentication a=SecurityContextHolder.getContext().getAuthentication(); String user=a!=null&&a.isAuthenticated()?a.getName():"anonimo";
  TipoEventoAuditoria tipo=tipo(m,uri,req); String entidade=entidade(uri); String id=id(uri);
  String campos=req.getParameterMap().keySet().stream().filter(k->!sensivel(k)).sorted().limit(20).reduce((x,y)->x+", "+y).orElse("");
  String det="Campos: "+campos+(ex==null?"":" | Erro: "+ex.getClass().getSimpleName());
  auditoria.registrar(user,tipo,entidade,id,m,uri,ip(req),req.getHeader("User-Agent"),res.getStatus(),det);
 }
 private static TipoEventoAuditoria tipo(String m,String u,HttpServletRequest r){if(m.equals("DELETE")||u.contains("/excluir")||u.contains("/remover"))return TipoEventoAuditoria.EXCLUSAO;if(u.contains("/salvar")){String id=r.getParameter("id");return id!=null&&!id.isBlank()?TipoEventoAuditoria.ALTERACAO:TipoEventoAuditoria.CRIACAO;}return TipoEventoAuditoria.ACAO;}
 private static String entidade(String u){String[] p=u.split("/");return p.length>1&&!p[1].isBlank()?p[1].toUpperCase(Locale.ROOT):"SISTEMA";}
 private static String id(String u){for(String p:u.split("/"))if(p.matches("\\d+"))return p;return null;}
 private static boolean sensivel(String k){String x=k.toLowerCase(Locale.ROOT);return x.contains("senha")||x.contains("password")||x.contains("token")||x.contains("secret");}
 private static String ip(HttpServletRequest r){String x=r.getHeader("X-Forwarded-For");return x!=null&&!x.isBlank()?x.split(",")[0].trim():r.getRemoteAddr();}
}
