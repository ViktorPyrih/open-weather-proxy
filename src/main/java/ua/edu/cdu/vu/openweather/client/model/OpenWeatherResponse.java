package ua.edu.cdu.vu.openweather.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenWeatherResponse {

    City city;
    List<OpenWeatherListResponse> list;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OpenWeatherListResponse {

        @JsonProperty("dt")
        long timestamp;
        OpenWeatherMainResponse main;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class OpenWeatherMainResponse {
            @JsonProperty("temp_min")
            double minTemperature;
            @JsonProperty("temp_max")
            double maxTemperature;
        }

    }
}
