package ua.edu.cdu.vu.openweather.domain;

import lombok.Builder;

@Builder
public record Coordinates(double latitude, double longitude) {
}
