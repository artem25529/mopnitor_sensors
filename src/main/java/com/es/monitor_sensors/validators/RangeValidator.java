package com.es.monitor_sensors.validators;

import com.es.monitor_sensors.models.Range;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, Range> {
    @Override
    public boolean isValid(final Range o, final ConstraintValidatorContext constraintValidatorContext) {
        return o.getTo() > o.getFrom();
    }
}
