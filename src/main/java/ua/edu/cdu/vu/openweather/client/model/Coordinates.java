package ua.edu.cdu.vu.openweather.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {

    @JsonProperty("lat")
    double latitude;
    @JsonProperty("lon")
    double longitude;

}
