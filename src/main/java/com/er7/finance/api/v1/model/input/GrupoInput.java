package com.er7.finance.api.v1.model.input;

import com.er7.finance.domain.model.Categoria;
import com.er7.finance.domain.model.Grupo;
import jakarta.validation.constraints.NotBlank;

public record GrupoInput(@NotBlank String nome, @NotBlank String descricao) {

    public Grupo toEntity () {
        return new Grupo(null, this.nome(), this.descricao());
    }
}
