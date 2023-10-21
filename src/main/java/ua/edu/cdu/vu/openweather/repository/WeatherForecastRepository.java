package ua.edu.cdu.vu.openweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.cdu.vu.openweather.entity.WeatherForecastEntity;
import ua.edu.cdu.vu.openweather.entity.WeatherForecastEntity.WeatherForecastId;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecastEntity, WeatherForecastId> {
}
