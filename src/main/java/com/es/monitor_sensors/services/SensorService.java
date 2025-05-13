package com.es.monitor_sensors.services;

import com.es.monitor_sensors.exceptions.InvalidIdException;
import com.es.monitor_sensors.models.Sensor;
import com.es.monitor_sensors.repositories.SensorRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Cacheable(cacheNames = "sensors")
    public List<Sensor> getAll() {
        return Lists.newArrayList(sensorRepository.findAll());
    }

    public Sensor getById(final Long id) throws InvalidIdException {
        final Optional<Sensor> optionalSensor = sensorRepository.findById(id);

        if (optionalSensor.isEmpty()) {
            throw new InvalidIdException("Sensor not found with id: " + id);
        }

        return optionalSensor.get();
    }

    public Long saveOrUpdate(final Sensor sensor) {
        return sensorRepository.save(sensor).getId();
    }

    @Transactional
    public List<Sensor> saveOrUpdateAll(final List<Sensor> sensors) {
        return sensorRepository.saveAllAndFlush(sensors);
    }

    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}
