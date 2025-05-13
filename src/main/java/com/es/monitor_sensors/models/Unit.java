package com.es.monitor_sensors.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "units")
@ToString(callSuper = true)
public class Unit extends BaseEntity {
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String unit;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
