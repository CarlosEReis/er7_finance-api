package com.er7.finance.api.v1.model.output;

import com.er7.finance.domain.model.Categoria;
import com.er7.finance.domain.model.Grupo;

import java.util.List;

public record GrupoOutput(Integer id, String nome, String descricao) {

    public static GrupoOutput fromEntity(Grupo grupo) {
        return new GrupoOutput(grupo.getId(), grupo.getNome(), grupo.getDescricao());
    }

    public static List<GrupoOutput> fromEntities(List<Grupo> categorias) {
        return categorias.stream().map(GrupoOutput::fromEntity).toList();
    }
}
