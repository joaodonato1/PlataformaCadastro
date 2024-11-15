package com.exemplo.plataformacursos.controller;

import com.exemplo.plataformacursos.model.Aluno;
import com.exemplo.plataformacursos.model.Curso;
import com.exemplo.plataformacursos.repository.AlunoRepository;
import com.exemplo.plataformacursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public String inscreverAlunoEmCurso(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.getCursos().add(curso);
        curso.getAlunos().add(aluno);

        alunoRepository.save(aluno);
        cursoRepository.save(curso);

        return "Aluno inscrito no curso com sucesso!";
    }
}