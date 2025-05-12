package com.es.monitor_sensors.validators;

import jakarta.validation.Constraint;

@Constraint(validatedBy = RangeToValidator.class)
public @interface GreaterThanFrom {
    String message() default "Should be greater that from";
}
