package org.bedu.java.backend.fase3_modulo1.controllers;


import org.bedu.java.backend.fase3_modulo1.model.Cliente;
import org.bedu.java.backend.fase3_modulo1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id){
        Optional<Cliente> clienteDb = clienteService.obtenCliente(id);

        if (clienteDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe.");
        }

        return ResponseEntity.ok(clienteDb.get());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cliente>> getClientes(){
        return ResponseEntity.ok(clienteService.obtenClientes());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> creaCliente(@RequestBody Cliente cliente){
        Cliente clienteNuevo = clienteService.guardaCliente(cliente);

        return ResponseEntity.created(URI.create(String.valueOf(clienteNuevo.getId()))).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizaCliente(@PathVariable("id") Long clienteId, @RequestBody Cliente cliente){
        clienteService.actualizaCliente(cliente);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaCliente(@PathVariable Long id){
        clienteService.eliminaCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
