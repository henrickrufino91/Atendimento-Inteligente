package br.com.portal.projeto.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="paciente_convenio", uniqueConstraints=@UniqueConstraint(name="uk_paciente_convenio_carteirinha",columnNames={"paciente_id","convenio_id","numero_carteirinha"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PacienteConvenio {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="paciente_id",nullable=false) private Paciente paciente;
 @ManyToOne(optional=false) @JoinColumn(name="convenio_id",nullable=false) private Convenio convenio;
 @Column(nullable=false,length=100) private String plano;
 @Column(name="numero_carteirinha",nullable=false,length=80) private String numeroCarteirinha;
 @Column(length=150) private String titular;
 private LocalDate validade;
 @Builder.Default @Column(nullable=false) private boolean ativo=true;
 public boolean isValido(){ return ativo && (validade==null || !validade.isBefore(LocalDate.now())); }
}
