package ua.edu.cdu.vu.openweather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.cdu.vu.openweather.domain.WeatherForecast;
import ua.edu.cdu.vu.openweather.service.WeatherForecastService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather-forecasts")
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping("/today")
    public WeatherForecast getForecastForToday(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherForecastService.getForecastForToday(latitude, longitude);
    }

    @GetMapping
    public List<WeatherForecast> getAllForecasts() {
        return weatherForecastService.getAllForecasts();
    }
}
