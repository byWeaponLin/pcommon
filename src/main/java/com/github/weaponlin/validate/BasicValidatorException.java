package com.github.weaponlin.validate;

import java.util.List;

import com.github.weaponlin.common.ErrorInfo;
import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BasicValidatorException extends RuntimeException{

    private List<ErrorInfo> errors;

    private String message;

    public BasicValidatorException(int code, String message) {
        ErrorInfo errorInfo = new ErrorInfo(code, message);
        errorInfo.setCode(code);
        errorInfo.setMessage(message);
        errors =  Lists.newArrayList(errorInfo);
    }

    public BasicValidatorException(List<ErrorInfo> errors) {
        this.errors = errors;
    }
}
