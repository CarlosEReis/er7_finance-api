package com.er7.finance.application;

import com.er7.finance.domain.exception.CategoriaNaoEncontradaException;
import com.er7.finance.domain.model.Categoria;
import com.er7.finance.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaApplicationService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaApplicationService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria criar (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional(readOnly = true)
    public List<Categoria> listar () {
        return categoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Categoria buscar (Integer id) {
        return categoriaRepository.findById(id)
            .orElseThrow(
                () -> new CategoriaNaoEncontradaException(id));
    }

    @Transactional
    public Categoria atualizar (Integer categoriaId, Categoria categoria) {
        var categoriaDb = buscar(categoriaId);
        categoriaDb.setNome(categoria.getNome());
        return categoriaRepository.save(categoriaDb);
    }

    @Transactional
    public void remover (Integer id) {
        Categoria categoria = buscar(id);
        categoriaRepository.delete(categoria);
    }
}
