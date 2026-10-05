package br.com.portal.projeto.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 150)
	@Column(nullable = false, length = 150)
	private String nome;
	@NotBlank
	@Size(max = 14)
	@Column(nullable = false, unique = true, length = 14)
	private String cpf;
	@Past
	@Column(nullable = false)
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Sexo sexo;
	@Email
	@Size(max = 150)
	private String email;
	@Size(max = 20)
	private String telefone;
	@Size(max = 255)
	private String endereco;
	@Size(max = 10)
	private String tipoSanguineo;
	@Size(max = 500)
	private String alergias;
	@Column(nullable = false, updatable = false)
	private LocalDateTime criadoEm;

	@PrePersist
	void prePersist() {
		if (criadoEm == null)
			criadoEm = LocalDateTime.now();
		if (sexo == null)
			sexo = Sexo.NAO_INFORMADO;
	}
}
