package com.es.monitor_sensors.repositories;

import com.es.monitor_sensors.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
