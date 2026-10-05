package br.com.portal.projeto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="auditoria", indexes={
 @Index(name="idx_auditoria_data", columnList="data_hora"),
 @Index(name="idx_auditoria_usuario", columnList="usuario"),
 @Index(name="idx_auditoria_evento", columnList="tipo_evento")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Auditoria {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="data_hora",nullable=false) private LocalDateTime dataHora;
 @Column(length=150) private String usuario;
 @Enumerated(EnumType.STRING) @Column(name="tipo_evento",nullable=false,length=30) private TipoEventoAuditoria tipoEvento;
 @Column(length=80) private String entidade;
 @Column(name="registro_id",length=80) private String registroId;
 @Column(nullable=false,length=10) private String metodo;
 @Column(nullable=false,length=500) private String rota;
 @Column(length=64) private String ip;
 @Column(name="user_agent",length=500) private String userAgent;
 @Column(nullable=false) private Integer statusHttp;
 @Column(length=1000) private String detalhes;
 @PrePersist void pre(){if(dataHora==null)dataHora=LocalDateTime.now();}
}
