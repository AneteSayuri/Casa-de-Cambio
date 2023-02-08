package com.ada.compra;

import com.ada.cliente.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component

public class ClienteAPIClient {
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private String URI = "http://localhost:8081/cliente/";
    public ClienteAPIClient(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webClientBuilder.baseUrl(URI).build();
    }
    public boolean existeCliente(String id) {
        String url = URI + id;
        return restTemplate.getForEntity(url, String.class).getStatusCode().is2xxSuccessful();
    }

    public ClienteDTO obterCliente(String cpf) {
        URI += cpf;
        Mono<ClienteDTO> registration = webClient.get().uri(URI)
                .retrieve().bodyToMono(ClienteDTO.class);
        return registration.block();
    }
}
