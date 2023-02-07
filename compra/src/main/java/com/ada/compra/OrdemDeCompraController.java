package com.ada.compra;

import com.ada.cliente.Cliente;
import com.ada.compra.exceptions.AgenciaInvalidaException;
import com.ada.compra.exceptions.ClienteInvalidoException;
import com.ada.compra.exceptions.MoedaInvalidaException;
import com.ada.compra.exceptions.ValorInvalidoException;
import com.ada.comum.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordem-de-compra")
public class OrdemDeCompraController {
    private final OrdemDeCompraService ordemDeCompraService;

    @PostMapping
    public ResponseEntity<OrdemDeCompra> add(@RequestBody OrdemDeCompraDTO ordemDeCompra) {
        if (ordemDeCompra == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra válida");
        }
        if (ordemDeCompra.getId_cliente() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra com um cpf atrelado válido.");
        }
        if (ordemDeCompra.getTipo_moeda()== null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma  ordem de compra com uma  moeda válida");
        }
        if (ordemDeCompra.getNumero_agencia_retirada() == null || ordemDeCompra.getNumero_agencia_retirada().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra com uma agência válida");
        }

        try {
            ordemDeCompraService.criarOrdemDeCompra(ordemDeCompra.toEntity());
        } catch (EntidadeDuplicadaException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma ordem de compra com o ID informado");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro desconhecido");
        }
        return ResponseEntity.created(URI.create("/api/ordem-de-compra/" + ordemDeCompra.getId_compra())).build();
    }

    @GetMapping
    public List<OrdemDeCompra> buscar(){
        return ordemDeCompraService.findAll();
    }

}


