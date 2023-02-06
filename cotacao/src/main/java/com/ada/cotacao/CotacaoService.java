package com.ada.cotacao;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CotacaoService {
    private RestTemplate restTemplate;
    private WebClient webClient;
    private final String url = "https://economia.awesomeapi.com.br/";

    public CotacaoService(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    public CotacaoDTO getCotacao(String code) {
        String urlCompleta = url + code;
        return this.restTemplate.getForObject(urlCompleta, CotacaoDTO.class);
    }
}
