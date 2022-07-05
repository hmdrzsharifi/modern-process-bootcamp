package com.caribou.bank.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SavingsAccountNotFoundException extends AbstractThrowableProblem {
    public SavingsAccountNotFoundException(String defaultMessage, String entityName, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
    }

    public SavingsAccountNotFoundException(URI type, String defaultMessage, String entityName, String errorKey) {
        super(type,defaultMessage, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
    }

    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }
}
