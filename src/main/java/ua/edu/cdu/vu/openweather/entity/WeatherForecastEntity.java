package ua.edu.cdu.vu.openweather.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "weather_forecast")
public class WeatherForecastEntity {

    @EmbeddedId
    private WeatherForecastId id;

    @Column(nullable = false)
    private Double minTemperature;
    @Column(nullable = false)
    private Double maxTemperature;

    @Data
    @Embeddable
    public static class WeatherForecastId implements Serializable {
        private LocalDate date;
        private Double latitude;
        private Double longitude;
    }
}
