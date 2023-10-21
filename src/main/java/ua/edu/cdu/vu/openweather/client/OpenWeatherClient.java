package ua.edu.cdu.vu.openweather.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import ua.edu.cdu.vu.openweather.client.model.OpenWeatherResponse;

public interface OpenWeatherClient {

    @GetExchange("?units={units}&appid={appid}")
    OpenWeatherResponse getForecast(@RequestParam("lat") double latitude, @RequestParam("lon") double longitude, @RequestParam("cnt") int daysCount);
}
