package com.exemplo.plataformacursos.repository;

import com.exemplo.plataformacursos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {}