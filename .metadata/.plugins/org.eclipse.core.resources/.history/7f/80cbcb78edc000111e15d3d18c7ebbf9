package br.com.portal.projeto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="convenio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Convenio {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=120) private String nome;
 @Column(name="registro_ans",length=30) private String registroAns;
 @Column(length=30) private String telefone;
 @Column(length=150) private String email;
 @Builder.Default @Column(nullable=false) private boolean ativo=true;
}
