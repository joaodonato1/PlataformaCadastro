package com.exemplo.plataformacursos.controller;

import com.exemplo.plataformacursos.dto.AlunoDTO;
import com.exemplo.plataformacursos.dto.CursoDTO;
import com.exemplo.plataformacursos.dto.InscricaoPopulator;
import com.exemplo.plataformacursos.model.Aluno;
import com.exemplo.plataformacursos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoRepository.save(aluno);
        return InscricaoPopulator.toAlunoDTO(novoAluno);
    }

    @GetMapping("/{id}/cursos")
    public List<CursoDTO> listarCursosDoAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return aluno.getCursos().stream()
                .map(InscricaoPopulator::toCursoDTO)
                .collect(Collectors.toList());
    }
}