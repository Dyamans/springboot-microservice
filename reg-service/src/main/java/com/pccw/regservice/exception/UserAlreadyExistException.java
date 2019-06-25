package com.pccw.regservice.exception;

import org.springframework.util.StringUtils;
import java.util.Map;


public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(Class clazz, String... searchParamsMap) {
        super(UserAlreadyExistException.generateMessage(clazz.getSimpleName(),
                ApiError.toMap(String.class, String.class, searchParamsMap)));
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +  " was already exist for parameters " + searchParams;
    }
}
