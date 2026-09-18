package br.com.portal.projeto.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	@NotNull
	@Column(nullable = false)
	private LocalDateTime dataHora;
	@Column(nullable = false, length = 100)
	private String tipo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusAgendamento status = StatusAgendamento.AGENDADO;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Prioridade prioridade = Prioridade.NORMAL;
	@Column(length = 500)
	private String observacoes;
}
