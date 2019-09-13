package com.dempaul.irens.test.palindromes.constraint;

import com.dempaul.irens.test.palindromes.constraint.impl.NumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = NumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {

    String message() default "{Number}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
