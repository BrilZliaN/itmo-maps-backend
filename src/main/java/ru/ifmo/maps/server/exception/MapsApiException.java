package ru.ifmo.maps.server.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class MapsApiException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

}
