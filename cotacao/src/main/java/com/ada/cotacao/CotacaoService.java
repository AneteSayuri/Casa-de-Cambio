package com.ada.cotacao;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CotacaoService {
    private RestTemplate restTemplate;
    private WebClient webClient;
    private String url = "https://economia.awesomeapi.com.br/";

    public CotacaoService(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public CotacaoDTO getCotacao(String code) {
        String urlCompleta = url + code;
        return this.restTemplate.getForObject(urlCompleta, CotacaoDTO.class);
    }

    public List<CotacaoEconomiaDTO> getCotacaoEconomia(String code) {
        String site = "https://economia.awesomeapi.com.br/";
        site += code;
        Flux<CotacaoEconomiaDTO> cotacaoFlux =
                webClient.get().uri(site).retrieve().bodyToFlux(CotacaoEconomiaDTO.class);

        return  cotacaoFlux
                .collect(Collectors.toList())
                .share().block();
    }

    public Optional<CotacaoDTO> obterCotacao(String code) {
        CotacaoEconomiaDTO cotacaoEconomiaDTO = getCotacaoEconomia(code).get(0);

        CotacaoDTO cotacaoDTO = new CotacaoDTO();
        cotacaoDTO.setAsk(cotacaoEconomiaDTO.getAsk());
        cotacaoDTO.setCode(cotacaoEconomiaDTO.getCode());
        cotacaoDTO.setCreate_date(LocalDate.now());

        return Optional.of(cotacaoDTO);
    }
}
