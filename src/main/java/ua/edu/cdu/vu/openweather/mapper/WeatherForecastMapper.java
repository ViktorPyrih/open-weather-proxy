package ua.edu.cdu.vu.openweather.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.edu.cdu.vu.openweather.client.model.City;
import ua.edu.cdu.vu.openweather.domain.Coordinates;
import ua.edu.cdu.vu.openweather.domain.WeatherForecast;
import ua.edu.cdu.vu.openweather.client.model.OpenWeatherResponse;
import ua.edu.cdu.vu.openweather.client.model.OpenWeatherResponse.OpenWeatherListResponse;
import ua.edu.cdu.vu.openweather.entity.WeatherForecastEntity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface WeatherForecastMapper {

    default List<WeatherForecast> convertToDomain(OpenWeatherResponse openWeatherResponse) {
        return openWeatherResponse.getList().stream()
                .map(openWeatherListResponse -> convertToDomain(openWeatherListResponse)
                        .withCoordinates(extractCoordinates(openWeatherResponse.getCity())))
                .toList();
    }

    @Mapping(target = "coordinates", ignore = true)
    @Mapping(target = "date", source = "timestamp")
    @Mapping(target = "temperature.min", source = "main.minTemperature")
    @Mapping(target = "temperature.max", source = "main.maxTemperature")
    WeatherForecast convertToDomain(OpenWeatherListResponse openWeatherListResponse);

    @Mapping(target = "date", source = "id.date")
    @Mapping(target = "coordinates.latitude", source = "id.latitude")
    @Mapping(target = "coordinates.longitude", source = "id.longitude")
    @Mapping(target = "temperature.min", source = "minTemperature")
    @Mapping(target = "temperature.max", source = "maxTemperature")
    WeatherForecast convertToDomain(WeatherForecastEntity entity);

    @Mapping(target = "id.date", source = "date")
    @Mapping(target = "id.latitude", source = "coordinates.latitude")
    @Mapping(target = "id.longitude", source = "coordinates.longitude")
    @Mapping(target = "minTemperature", source = "temperature.min")
    @Mapping(target = "maxTemperature", source = "temperature.max")
    WeatherForecastEntity convertToEntity(WeatherForecast domain);

    @Mapping(target = "latitude", source = "coordinates.latitude")
    @Mapping(target = "longitude", source = "coordinates.longitude")
    Coordinates extractCoordinates(City city);

    default LocalDate epochSecondsToLocalDate(long timestamp) {
        return Instant.ofEpochSecond(timestamp).atZone(UTC).toLocalDate();
    }
}
