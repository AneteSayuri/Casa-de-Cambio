import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CotacaoService {
    private RestTemplate restTemplate;
    private WebClient webClient;
    private final String usd = "https://economia.awesomeapi.com.br/USD";
    private final String eur = "https://economia.awesomeapi.com.br/EUR";

}
