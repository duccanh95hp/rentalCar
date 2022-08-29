package com.example.rentalcar.validator;

import com.example.rentalcar.model.UsersEntity;
import com.example.rentalcar.service.userSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component

public class userValidator implements Validator {
    @Autowired
    private userSerice userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UsersEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UsersEntity user = (UsersEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (user.getName().length() < 6 || user.getName().length() > 32) {
            errors.getAllErrors();
        }
        if (userService.findByUsername(user.getName()) != null) {
            errors.getAllErrors();
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.getAllErrors();
        }

    }

}
