package com.epam.controller.util;

import com.epam.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Sahak_Babayan on 4/1/2016.
 */
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "err.field.first.name.required", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "err.field.last.name.required", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "err.field.email.required", "Email is required.");
    }
}
