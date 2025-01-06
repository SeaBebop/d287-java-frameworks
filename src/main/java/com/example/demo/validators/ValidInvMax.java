package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxPartValidator.class)
public @interface ValidInvMax {

    String message() default "Max need to be higher than min";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}