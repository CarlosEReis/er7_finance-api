package com.er7.finance.api.v1.controller;

import com.er7.finance.api.v1.model.input.CategoriaInput;
import com.er7.finance.api.v1.model.output.CategoriaOutput;
import com.er7.finance.api.v1.openapi.CategoriaControllerOpenApi;
import com.er7.finance.application.CategoriaApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categorias")
public class CategoriaController implements CategoriaControllerOpenApi {

    private final CategoriaApplicationService categoriaApplicationService;

    public CategoriaController(CategoriaApplicationService categoriaApplicationService) {
        this.categoriaApplicationService = categoriaApplicationService;
    }

    @PostMapping()
    public ResponseEntity<CategoriaOutput> criar(@RequestBody CategoriaInput input) {
        return ResponseEntity.ok(
            CategoriaOutput.fromEntity(
                categoriaApplicationService.criar(input.toEntity())));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaOutput>> listar() {
        return ResponseEntity.ok(
            CategoriaOutput.fromEntities(
                categoriaApplicationService.listar()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaOutput> atualizar(@PathVariable Integer id, @RequestBody CategoriaInput input) {
        return ResponseEntity.ok(
            CategoriaOutput.fromEntity(
                categoriaApplicationService.atualizar(id, input.toEntity())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        categoriaApplicationService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
