package br.com.portal.projeto.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prescricao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescricao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "atendimento_id")
	private Atendimento atendimento;
	@Column(nullable = false, length = 150)
	private String medicamento;
	@Column(nullable = false, length = 100)
	private String dosagem;
	@Column(nullable = false, length = 100)
	private String frequencia;
	@Column(length = 100)
	private String duracao;
	@Column(length = 500)
	private String orientacoes;
	@Column(nullable = false)
	private LocalDateTime criadoEm;

	@PrePersist
	void pre() {
		if (criadoEm == null)
			criadoEm = LocalDateTime.now();
	}
}
