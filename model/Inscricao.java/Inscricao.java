package com.exemplo.plataformacursos.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate dataInscricao;

    // Getters e Setters
}