package com.er7.finance.domain.repository;

import com.er7.finance.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    List<Grupo> findByNomeStartingWithIgnoreCase(String nome);
}
