package com.es.monitor_sensors.models;

import com.es.monitor_sensors.validators.ValidRange;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Setter
@Getter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Range {
    @Column(name = "from_val")
    private int from;

    @Column(name = "to_val")
    private int to;
}
