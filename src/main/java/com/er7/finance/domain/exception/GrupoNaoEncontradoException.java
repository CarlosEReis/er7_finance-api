package com.er7.finance.domain.exception;

public class GrupoNaoEncontradoException extends RuntimeException{

    public GrupoNaoEncontradoException(Integer id) {
        super("Grupo com ID " + id + " não encontrado.");
    }
}
