package com.exemplo.plataformacursos.controller;

import com.exemplo.plataformacursos.dto.AlunoDTO;
import com.exemplo.plataformacursos.dto.CursoDTO;
import com.exemplo.plataformacursos.dto.InscricaoPopulator;
import com.exemplo.plataformacursos.model.Curso;
import com.exemplo.plataformacursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoRepository.save(curso);
        return InscricaoPopulator.toCursoDTO(novoCurso);
    }

    @GetMapping("/{id}/alunos")
    public List<AlunoDTO> listarAlunosDoCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return curso.getAlunos().stream()
                .map(InscricaoPopulator::toAlunoDTO)
                .collect(Collectors.toList());
    }
}