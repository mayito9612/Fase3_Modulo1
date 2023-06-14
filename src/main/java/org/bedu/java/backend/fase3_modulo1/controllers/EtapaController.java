package org.bedu.java.backend.fase3_modulo1.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.fase3_modulo1.model.Etapa;
import org.bedu.java.backend.fase3_modulo1.service.EtapaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etapa")
@RequiredArgsConstructor
public class EtapaController {
    private final EtapaService etapaService;

    @GetMapping("/{etapaId}")
    public ResponseEntity<Etapa> getEtapa(@PathVariable Long etapaId){
        Optional<Etapa> etapaDb = etapaService.obtenEtapa(etapaId);

        if (etapaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La etapa especificada no existe.");
        }

        return ResponseEntity.ok(etapaDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Etapa>> getEtapas(@RequestParam Long clienteId){
        return ResponseEntity.ok(etapaService.obtenEtapas());
    }

    @PostMapping
    public ResponseEntity<Void> creaEtapa(@RequestBody Etapa etapa, @RequestParam Long clienteId){
        Etapa etapaNueva = etapaService.guardaEtapa(etapa);

        return ResponseEntity.created(URI.create(String.valueOf(etapaNueva.getEtapaId()))).build();
    }

    @PutMapping("/{etapaId}")
    public ResponseEntity<Void> actualizaEtapa(@PathVariable Long etapaId, @RequestBody Etapa etapa){
        etapaService.actualizaEtapa(etapa);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{etapaId}")
    public ResponseEntity<Void> eliminaEtapa(@PathVariable Long etapaId){
        etapaService.eliminaEtapa(etapaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
