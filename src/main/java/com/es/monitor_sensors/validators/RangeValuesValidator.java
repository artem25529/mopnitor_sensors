package com.es.monitor_sensors.validators;

import com.es.monitor_sensors.models.Range;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValuesValidator implements ConstraintValidator<PositiveValues, Range> {
    @Override
    public boolean isValid(final Range range, final ConstraintValidatorContext constraintValidatorContext) {
        return range.getFrom() > 0 && range.getTo() > 0;
    }
}
