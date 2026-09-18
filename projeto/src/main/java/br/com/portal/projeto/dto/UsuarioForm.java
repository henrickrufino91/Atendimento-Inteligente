package br.com.portal.projeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UsuarioForm {
    private Long id;
    @NotBlank @Size(max=120) private String nome;
    @NotBlank @Email @Size(max=150) private String email;
    private String senha;
    @Builder.Default private boolean ativo = true;
    @Builder.Default private List<Long> perfilIds = new ArrayList<>();
}
