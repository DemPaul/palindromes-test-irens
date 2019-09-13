package com.dempaul.irens.test.palindromes.constraint.impl;

import com.dempaul.irens.test.palindromes.constraint.Number;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<Number, String> {

    @Override
    public void initialize(Number number) {
    }

    @Override
    public boolean isValid(String numberField, ConstraintValidatorContext cxt) {
        if (numberField.equals("")) {
            return true;
        }
        String regex = "[0-9]+";

        return numberField.matches(regex);
    }
}
