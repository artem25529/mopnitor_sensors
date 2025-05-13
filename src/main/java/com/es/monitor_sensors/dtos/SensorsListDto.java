package com.es.monitor_sensors.dtos;

import com.es.monitor_sensors.models.Sensor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorsListDto {
    private List<@Valid Sensor> sensors;
}
