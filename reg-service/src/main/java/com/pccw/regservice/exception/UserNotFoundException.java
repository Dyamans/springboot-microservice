package com.pccw.regservice.exception;

import org.springframework.util.StringUtils;
import java.util.Map;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Class clazz, String... searchParamsMap) {
        super(UserNotFoundException.generateMessage(clazz.getSimpleName(),
               ApiError.toMap(String.class, String.class, searchParamsMap)));
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) + " was not found for parameters " + searchParams;
    }

}
