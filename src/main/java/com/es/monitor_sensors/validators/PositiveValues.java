package com.es.monitor_sensors.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = RangeValuesValidator.class)
public @interface PositiveValues {
    String message() default "{numbers.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
