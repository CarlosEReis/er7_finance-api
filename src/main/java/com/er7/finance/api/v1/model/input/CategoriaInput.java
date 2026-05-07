package com.er7.finance.api.v1.model.input;

import com.er7.finance.domain.model.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaInput (@NotBlank String nome) {

    public Categoria toEntity () {
        return new Categoria(null, this.nome());
    }
}
