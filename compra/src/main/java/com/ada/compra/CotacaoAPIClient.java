package com.ada.compra;

import com.ada.cotacao.CotacaoDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CotacaoAPIClient {
    private RestTemplate restTemplate;
    private WebClient webClient;
    private String URI = "http://localhost:8083/";

    public CotacaoAPIClient(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(URI).build();
    }

    public CotacaoDTO obterCotacao(String code) {
        String urlCompleta = URI + code;
        return this.restTemplate.getForObject(urlCompleta, CotacaoDTO.class);
    }

    public CotacaoDTO getCotacao(String code) {
        String cotacaoApi = "http://localhost:8083/cotacao/";
        cotacaoApi += code;
        Mono<CotacaoDTO> cotacao = webClient.get().uri(cotacaoApi)
                .retrieve().bodyToMono(CotacaoDTO.class);
        return cotacao.block();
    }

}
