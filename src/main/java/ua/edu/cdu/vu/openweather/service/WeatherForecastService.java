package ua.edu.cdu.vu.openweather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.cdu.vu.openweather.exception.NotFoundException;
import ua.edu.cdu.vu.openweather.client.OpenWeatherClient;
import ua.edu.cdu.vu.openweather.domain.WeatherForecast;
import ua.edu.cdu.vu.openweather.client.model.OpenWeatherResponse;
import ua.edu.cdu.vu.openweather.entity.WeatherForecastEntity;
import ua.edu.cdu.vu.openweather.mapper.WeatherForecastMapper;
import ua.edu.cdu.vu.openweather.repository.WeatherForecastRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherForecastService {

    private static final int ONE_DAY = 1;

    private final OpenWeatherClient openWeatherClient;
    private final WeatherForecastRepository weatherForecastRepository;
    private final WeatherForecastMapper weatherForecastMapper;

    public WeatherForecast getForecastForToday(double latitude, double longitude) {
        OpenWeatherResponse weatherResponse = openWeatherClient.getForecast(latitude, longitude, ONE_DAY);
        WeatherForecast weatherForecast = weatherForecastMapper.convertToDomain(weatherResponse).stream()
                .findAny()
                .orElseThrow(() -> new NotFoundException("Forecast for today cannot be found"));

        WeatherForecastEntity forecastEntity = weatherForecastMapper.convertToEntity(weatherForecast);
        weatherForecastRepository.save(forecastEntity);

        return weatherForecast;
    }

    public List<WeatherForecast> getAllForecasts() {
        return weatherForecastRepository.findAll().stream()
                .map(weatherForecastMapper::convertToDomain)
                .toList();
    }
}
