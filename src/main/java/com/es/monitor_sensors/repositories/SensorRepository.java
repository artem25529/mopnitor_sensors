package com.es.monitor_sensors.repositories;

import com.es.monitor_sensors.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
