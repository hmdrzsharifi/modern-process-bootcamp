package com.caribou.bank.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface ResponseUtil {

    static <x> ResponseEntity<x> wrapOrNotFound(Optional<x> maybeResponse){
        return wrapOrNotFound(maybeResponse, (HttpHeaders)null);
    }

    static <x> ResponseEntity<x> wrapOrNotFound(Optional<x> maybeResponse, HttpHeaders header) {
        return (ResponseEntity)maybeResponse.map((response) -> {
            return ResponseEntity.ok().headers(header).body(response);
        }).orElseThrow(() -> {
           return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }


}
