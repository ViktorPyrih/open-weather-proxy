package ua.edu.cdu.vu.openweather.domain;

import lombok.*;

@Builder
public record Temperature(double min, double max) {
}
