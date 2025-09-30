package com.gabriela.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="filme")
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nome", unique = true)
    private String nome;

    @Column(name="ano")
    private String ano;

    @Column(name="diretor")
    private String diretor;
}
