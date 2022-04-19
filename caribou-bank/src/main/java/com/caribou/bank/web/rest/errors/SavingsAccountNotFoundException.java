package com.caribou.bank.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SavingsAccountNotFoundException extends AbstractThrowableProblem {


    public SavingsAccountNotFoundException(String defaultMessage, String entityId, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityId, errorKey);
    }

    public SavingsAccountNotFoundException(URI type, String defaultMessage, String entityId, String errorKey) {
        super(type,defaultMessage, Status.NOT_FOUND, null, null, null, getAlertParameters(entityId, errorKey));
    }

    private static Map<String, Object> getAlertParameters(String entityId, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityId);
        return parameters;
    }
}
