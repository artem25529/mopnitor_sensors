package com.es.monitor_sensors.services;

import com.es.monitor_sensors.models.Unit;
import com.es.monitor_sensors.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAll() {
        return unitRepository.findAll();
    }
}
