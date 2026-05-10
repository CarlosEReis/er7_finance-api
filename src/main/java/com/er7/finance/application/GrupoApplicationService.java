package com.er7.finance.application;

import com.er7.finance.domain.exception.GrupoNaoEncontradoException;
import com.er7.finance.domain.model.Grupo;
import com.er7.finance.domain.repository.GrupoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrupoApplicationService {

    private final GrupoRepository grupoRepository;

    public GrupoApplicationService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Transactional
    public Grupo criar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Transactional(readOnly = true)
    public List<Grupo> listar() {
        return grupoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Grupo buscar(Integer id) {
        return grupoRepository.findById(id)
            .orElseThrow(
                () -> new GrupoNaoEncontradoException(id));
    }

    @Transactional(readOnly = true)
    public List<Grupo> buscarPor(String nome) {
        return grupoRepository.findByNomeStartingWithIgnoreCase(nome);
    }

}
