package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinxMaxPartValidator.class)
public @interface ValidInvBetween {

    String message() default "Inventory must be between minimum and maximum values";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}