package com.er7.finance.api.v1.model.output;

import com.er7.finance.domain.model.Categoria;

import java.util.List;

public record CategoriaOutput(Integer id, String nome) {

    public static CategoriaOutput fromEntity(Categoria categoria) {
        return new CategoriaOutput(categoria.getId(), categoria.getNome());
    }

    public static List<CategoriaOutput> fromEntities(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaOutput::fromEntity).toList();
    }
}
