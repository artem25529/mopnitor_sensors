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
@Table(name = "types")
@ToString(callSuper = true)
public class Type extends BaseEntity {
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String type;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
