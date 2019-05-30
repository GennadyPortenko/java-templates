package gpk.annotations.validation;

import gpk.annotations.example.CustomParameterValidationAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomParameterValidator implements ConstraintValidator<CustomParameterValidationAnnotation, String> {
    @Override
    public void initialize(CustomParameterValidationAnnotation customParameterValidationAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        return false;
    }
}
