package com.fred.sign.domain;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author upgrade2004
 */

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4478325141336771024L;

    private Integer id;
    private Integer age;
    private String name;

}
