package ru.ifmo.maps.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.ifmo.maps.server.builder.MapsApiErrorBuilder;
import ru.ifmo.maps.server.exception.ExceptionFactory;
import ru.ifmo.maps.server.exception.MapsApiError;
import ru.ifmo.maps.server.exception.MapsApiException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MapsApiException.class)
    public final ResponseEntity<MapsApiError> handle(MapsApiException exception, WebRequest request) {
        exception.printStackTrace();
        MapsApiError error = MapsApiErrorBuilder.build(exception);
        return new ResponseEntity<>(error, exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<MapsApiError> handle(Exception exception, WebRequest request) {
        exception.printStackTrace();
        MapsApiException MapsApiException = ExceptionFactory.wrap(exception);
        MapsApiError error = MapsApiErrorBuilder.build(MapsApiException);
        return new ResponseEntity<>(error, MapsApiException.getHttpStatus());
    }

}