package ua.edu.cdu.vu.openweather.domain;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
@Builder
public record WeatherForecast(LocalDate date, Coordinates coordinates,
                              Temperature temperature) {
}
