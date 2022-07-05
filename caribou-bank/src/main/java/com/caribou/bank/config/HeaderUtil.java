package com.caribou.bank.config;

import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HeaderUtil {


    public static HttpHeaders createEntityCreationAlert(String applicationName, boolean enableTranslation, String entityName, String param){
        String message = enableTranslation ? applicationName + "." + entityName + ".created" : "A new " + entityName + " is created with identifier " + param;
        return createAlert(applicationName, message, param);
    }

    public static HttpHeaders createEntityUpdateAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? applicationName + "." + entityName + ".updated" : "A " + entityName + " is updated with identifier " + param;
        return createAlert(applicationName, message, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? applicationName + "." + entityName + ".deleted" : "A " + entityName + " is deleted with identifier " + param;
        return createAlert(applicationName, message, param);
    }

    private static HttpHeaders createAlert(String applicationName, String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-alert", message);

        try{
            headers.add("X-" + applicationName + "-params", URLEncoder.encode(param, StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException var5){

        }
        return headers;
    }
}
