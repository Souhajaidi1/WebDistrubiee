package tn.esprit.prestationdeservice.msprestation.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumValidatorValidator implements ConstraintValidator<EnumValidator, Enum<?>> {
    private Set<String> allowedValues;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        allowedValues = Arrays.stream(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are allowed
        }
        return allowedValues.contains(value.name());
    }
}

