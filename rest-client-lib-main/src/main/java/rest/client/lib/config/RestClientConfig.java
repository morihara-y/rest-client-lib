package rest.client.lib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import rest.client.lib.RestClient;
import rest.client.lib.RestClientImpl;


@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClient() {
        return new RestClientImpl(new RestTemplate());
    }
}
