package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinxMaxPartValidator implements ConstraintValidator<ValidInvBetween, Part> {

    @Override
    public void initialize(ValidInvBetween constraintAnnotation) {

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
        context.buildConstraintViolationWithTemplate("Inventory needs to be between the min and max inventory,Current Values:" + invMin + " and " + invMax)
                .addPropertyNode("inv")
                .addConstraintViolation();
        // Validate that inv is between invMin and invMax
        return inv >= invMin && inv <= invMax && inv > 0;
    }
}