package com.es.monitor_sensors.services;

import com.es.monitor_sensors.exceptions.InvalidIdException;
import com.es.monitor_sensors.models.Sensor;
import com.es.monitor_sensors.models.Unit;
import com.es.monitor_sensors.repositories.SensorRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAll() {
        return Lists.newArrayList(sensorRepository.findAll());
    }

    public Sensor getById(final Long id) throws InvalidIdException {
        final Optional<Sensor> optionalSensor = sensorRepository.findById(id);

        if (optionalSensor.isEmpty()) {
            throw new InvalidIdException("Sensor not found with id: " + id);
        }

        final Sensor sensor = optionalSensor.get();
        if (sensor.getUnit() == null) {
            sensor.setUnit(new Unit());
        }

        return sensor;
    }

    @Transactional
    public Long saveOrUpdate(final Sensor sensor) {
        setUnitToNullIfUnspecified(sensor);
        return sensorRepository.save(sensor).getId();
    }

    @Transactional
    public List<Sensor> saveOrUpdateAll(final List<Sensor> sensors) {
        sensors.forEach(this::setUnitToNullIfUnspecified);
        return sensorRepository.saveAllAndFlush(sensors);
    }

    @Transactional
    public void deleteById(final Long id) {
        sensorRepository.deleteById(id);
    }

    private void setUnitToNullIfUnspecified(final Sensor sensor) {
        if (sensor.getUnit().getId() == null) {
            sensor.setUnit(null);
        }
    }
}
