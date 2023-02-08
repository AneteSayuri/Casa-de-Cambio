package com.ada.cotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/cotacao")
//NÃO FUNCIONOU SEM UM MAPPING
public class CotacaoController {

    private final CotacaoService cotacaoService;

    @GetMapping("/{moeda}")
    public ResponseEntity<CotacaoDTO> obterCotacao(@PathVariable String moeda) {
        if (!(moeda.equals("USD") || moeda.equals("EUR"))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda informada não é válida!");
        }

        Optional<CotacaoDTO> cotacaoAPI = cotacaoService.obterCotacao(moeda);
        cotacaoAPI.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cotação não encontrada!"));
        CotacaoDTO cotacaoDTO = cotacaoAPI.get();

        return ResponseEntity.ok(cotacaoDTO);
    }
}
