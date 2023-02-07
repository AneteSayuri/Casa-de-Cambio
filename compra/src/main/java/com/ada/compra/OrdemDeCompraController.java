package com.ada.compra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody OrdemDeCompraDTO ordemDeCompraDTO) {
        return ResponseEntity.created(URI.create("/api/ordem-de-compra/" + ordemDeCompraDTO.getId_compra())).build();
    }

}


