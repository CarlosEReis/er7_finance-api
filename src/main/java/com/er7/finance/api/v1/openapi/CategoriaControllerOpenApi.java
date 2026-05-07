package com.er7.finance.api.v1.openapi;

import com.er7.finance.api.v1.model.input.CategoriaInput;
import com.er7.finance.api.v1.model.output.CategoriaOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categoria", description = "Representa uma categoria de gasto dentro de um Lançamento")
public interface CategoriaControllerOpenApi {

    @Operation(summary = "Cria uma nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    ResponseEntity<CategoriaOutput> criar(@RequestBody CategoriaInput input);

    @Operation(summary = "Lista todas as categorias não deletadas")
    @ApiResponse(responseCode = "200", description = "Lista de categorias")
    ResponseEntity<List<CategoriaOutput>> listar();

    @Operation(summary = "Atualiza uma categoria existente")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada")
    ResponseEntity<CategoriaOutput> atualizar(@PathVariable Integer id, @RequestBody CategoriaInput input);

    @Operation(summary = "Remove uma categoria existente")
    @ApiResponse(responseCode = "204", description = "Categoria removida")
    ResponseEntity<Void> remover(@PathVariable Integer id);

}
