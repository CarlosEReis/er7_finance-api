package com.er7.finance.domain.exception;

public class CategoriaNaoEncontradaException extends RuntimeException{

    public CategoriaNaoEncontradaException(Integer id) {
        super("Categoria com ID " + id + " não encontrada.");
    }
}
