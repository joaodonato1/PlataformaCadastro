package com.exemplo.plataformacursos.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDate dataCriacao;

    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos = new HashSet<>();

    // Getters e Setters
}