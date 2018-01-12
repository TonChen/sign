package com.fred.sign.service;

import com.fred.sign.properties.FooProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author upgrade2004
 */
@Service
@Slf4j
public class UserService {

    private final FooProperties fooProperties;

    @Autowired
    public UserService(FooProperties fooProperties) {
        this.fooProperties = fooProperties;
    }

    @PostConstruct
    public void openConnection(){
        log.info("获取到的链接为：{}", fooProperties.getRemoteAddress());
        log.info("获取到的链接为：{}", fooProperties.getSecurity().getUsername());
        log.info("获取到的链接为：{}", fooProperties.getSecurity().getRoles());
    }

}
