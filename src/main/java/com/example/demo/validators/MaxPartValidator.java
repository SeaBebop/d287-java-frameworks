package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxPartValidator implements ConstraintValidator<ValidInvMax, Part> {

    @Override
    public void initialize(ValidInvMax constraintAnnotation) {

    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true;
        }

        // Fetch values from the part object
        int inv = part.getInv();
        int invMin = part.getInvMin();
        int invMax = part.getInvMax();
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Maximum inventory must be greater than or equal to minimum inventory and positive")
                .addPropertyNode("invMax")
                .addConstraintViolation();

        // Validate that  invMax is higher than invMin
        return invMax >= invMin && invMax > 0;
    }
}