package com.er7.finance.api.v1.openapi;

import com.er7.finance.api.v1.model.input.CategoriaInput;
import com.er7.finance.api.v1.model.input.GrupoInput;
import com.er7.finance.api.v1.model.output.CategoriaOutput;
import com.er7.finance.api.v1.model.output.GrupoOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Grupo", description = "Representa um grupo que compartilha os lançamentos")
public interface GrupoControllerOpenApi {

    @Operation(summary = "Cria uma novo grupo")
    @ApiResponse(responseCode = "201", description = "Grupo criado com sucesso")
    ResponseEntity<GrupoOutput> criar(@RequestBody GrupoInput input);

    @Operation(summary = "Lista todos os grupos ativos")
    @ApiResponse(responseCode = "200", description = "Lista dos grupos")
    ResponseEntity<List<GrupoOutput>> listar();

    @Operation(summary = "Busca um grupo pelo nome")
    @ApiResponse(responseCode = "200", description = "Lista dos grupos que contém o nome")
    ResponseEntity<List<GrupoOutput>> buscarPor(@PathVariable String nome);

}
