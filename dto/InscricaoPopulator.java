package com.exemplo.plataformacursos.dto;

import com.exemplo.plataformacursos.model.Aluno;
import com.exemplo.plataformacursos.model.Curso;

public class InscricaoPopulator {
    public static AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public static CursoDTO toCursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }
}