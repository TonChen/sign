package com.fred.sign.controller;

import com.fred.sign.base.BaseController;
import com.fred.sign.domain.User;
import com.fred.sign.exception.CommonException;
import com.fred.sign.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * @author upgrade2004
 */

@Slf4j
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public Object home(@RequestParam(value = "id", required = false) Integer id, @Valid User user, BindingResult bindingResult) {
        userService.openConnection();
        log.info("请求的数据是：{}, {}" , id, user);

        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuffer sb = new StringBuffer("");
            errors.forEach((error) -> {
                log.error(" {} ", ((FieldError)error).getField()+"："+error.getDefaultMessage());
                sb.append(((FieldError)error).getField()+"："+error.getDefaultMessage());
            });
            throw new CommonException("1000", sb.toString());
        }

        return "Hello, Spring boot";
    }


    @PostMapping("hello")
    public Object hello(@RequestParam Integer id, @RequestParam(required = false) Date date){

        return "你好~"+date;
    }

}
