package ua.edu.cdu.vu.openweather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ua.edu.cdu.vu.openweather.client.OpenWeatherClient;

import java.util.Map;

@Configuration
public class OpenWeatherClientConfiguration {

    @Value("${open.weather.base.url}")
    private String openWeatherBaseUrl;

    @Value("${open.weather.api-key}")
    private String openWeatherApiKey;

    @Value("${open.weather.units}")
    private String units;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(openWeatherBaseUrl)
                .defaultUriVariables(Map.of(
                        "appid", openWeatherApiKey,
                        "units", units
                        )
                )
                .build();
    }

    @Bean
    public OpenWeatherClient tvMazeClient(WebClient webClient) {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build().createClient(OpenWeatherClient.class);
    }
}
