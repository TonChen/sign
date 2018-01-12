package com.fred.sign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author upgrade2004
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonException extends RuntimeException {
    private String code;
    private String errorMsg;

}
