package com.er7.finance.api.v1.controller;

import com.er7.finance.api.v1.model.input.GrupoInput;
import com.er7.finance.api.v1.model.output.GrupoOutput;
import com.er7.finance.api.v1.openapi.GrupoControllerOpenApi;
import com.er7.finance.application.GrupoApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/grupos")
public class GrupoController implements GrupoControllerOpenApi {

    private final GrupoApplicationService grupoApplicationService;

    public GrupoController(GrupoApplicationService grupoApplicationService) {
        this.grupoApplicationService = grupoApplicationService;
    }

    @PostMapping
    public ResponseEntity<GrupoOutput> criar(@RequestBody GrupoInput input) {
        return ResponseEntity.ok(
            GrupoOutput.fromEntity(
                grupoApplicationService.criar(input.toEntity())));
    }

    @GetMapping
    public ResponseEntity<List<GrupoOutput>> listar() {
        return ResponseEntity.ok(
            GrupoOutput.fromEntities(
                grupoApplicationService.listar()));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<GrupoOutput>> buscarPor(@PathVariable String nome) {
        return ResponseEntity.ok(
            GrupoOutput.fromEntities(
                grupoApplicationService.buscarPor(nome)));
    }

}
