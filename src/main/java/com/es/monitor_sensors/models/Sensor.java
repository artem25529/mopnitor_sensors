package com.es.monitor_sensors.models;

import com.es.monitor_sensors.validators.ValidRange;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensors")
@ToString(callSuper = true)
public class Sensor extends BaseEntity {
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String model;

    @Valid
    @Embedded
    @ValidRange
    private Range range;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE})
    private Type type = new Type();

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE})
    private Unit unit = new Unit();

    @Size(max = 40)
    private String location;

    @Size(max = 40)
    private String description;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
