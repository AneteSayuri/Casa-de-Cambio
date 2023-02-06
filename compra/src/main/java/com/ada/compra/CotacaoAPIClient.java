package com.ada.compra;

import com.ada.cotacao.CotacaoDTO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CotacaoAPIClient {
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private String URI = "http://localhost:8083/";

    public CotacaoAPIClient(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(URI).build();
    }

    public CotacaoDTO getCotacao(String code) {
        String urlCompleta = URI + code;
        return this.restTemplate.getForObject(urlCompleta, CotacaoDTO.class);
    }

}
