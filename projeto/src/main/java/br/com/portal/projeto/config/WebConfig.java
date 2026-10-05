package br.com.portal.projeto.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration @RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
 private final AuditoriaInterceptor auditoriaInterceptor;
 @Override public void addInterceptors(InterceptorRegistry registry){registry.addInterceptor(auditoriaInterceptor).addPathPatterns("/**");}
}
