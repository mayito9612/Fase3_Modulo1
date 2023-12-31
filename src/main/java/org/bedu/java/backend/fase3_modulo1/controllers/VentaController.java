package org.bedu.java.backend.fase3_modulo1.controllers;
import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.fase3_modulo1.model.Venta;
import org.bedu.java.backend.fase3_modulo1.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService ventaService;

    @GetMapping("/{ventaId}")
    public ResponseEntity<Venta> getVenta(@PathVariable Long ventaId){
        Optional<Venta> ventaDb = ventaService.obtenVenta(ventaId);

        if (ventaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La venta especificada no existe.");
        }

        return ResponseEntity.ok(ventaDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Venta>> getVentas(@RequestParam Long clienteId){
        return ResponseEntity.ok(ventaService.obtenVentas());
    }

    @PostMapping
    public ResponseEntity<Void> creaVenta(@RequestBody Venta venta, @RequestParam Long clienteId){
        Venta ventaNueva = ventaService.guardaVenta(venta);

        return ResponseEntity.created(URI.create(String.valueOf(ventaNueva.getVentaId()))).build();
    }

    @PutMapping("/{ventaId}")
    public ResponseEntity<Void> actualizaVenta(@PathVariable Long ventaId, @RequestBody Venta venta){
        ventaService.actualizaVenta(venta);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{ventaId}")
    public ResponseEntity<Void> eliminaVenta(@PathVariable Long ventaId){
        ventaService.eliminaVenta(ventaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
