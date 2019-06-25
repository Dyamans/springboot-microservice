package com.pccw.regservice.validator;


import com.pccw.regservice.model.User;
import com.pccw.regservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {

        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");

        if (user.getName().length() < 3 || user.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.name");
        }


        if (user.getPhone().length() != 10 ) {
            errors.rejectValue("phone", "Size.userForm.phone");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        if (!user.getEmail().equals(user.getEmail())) {
            errors.rejectValue("email", "Diff.userForm.email");
        }
    }
}
