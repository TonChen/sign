package com.fred.sign.validation;

import com.fred.sign.domain.User;
import com.fred.sign.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@Slf4j
public class RequestValidation {


    @ModelAttribute
    public User newUser(){
        log.info("init user ...");
        return null;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new UserValidator());
        //在request执行之前处理数据
        webDataBinder.registerCustomEditor(int.class, new CustomNumberEditor(Integer.class, true));
        //在request执行之前处理数据
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true ));
    }

    @ResponseBody
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object handleException(NativeWebRequest request, CommonException e){
        log.info("handle req exception ：{}", request.getNativeRequest().toString());
        return e.getErrorMsg();
    }


}
