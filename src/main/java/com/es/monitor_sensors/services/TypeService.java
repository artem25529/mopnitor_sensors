package com.es.monitor_sensors.services;

import com.es.monitor_sensors.models.Type;
import com.es.monitor_sensors.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
