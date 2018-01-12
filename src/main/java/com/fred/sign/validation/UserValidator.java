package com.fred.sign.validation;

import com.fred.sign.domain.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author upgrade2004
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;
        Integer age = user.getAge();
        String name = user.getName();

        if(age == null || age < 18){
            errors.rejectValue("age",null,"年龄不能为空或者小于18岁");
        }

        if(StringUtils.isEmpty(name)){
            ValidationUtils.rejectIfEmpty(errors, "name", null, "名称不能为空");
        }
    }

}
