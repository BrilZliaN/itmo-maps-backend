package ru.ifmo.maps.server.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

public class ExceptionFactory {

    public static MapsApiException wrap(DataAccessException exception) {
        return wrap(exception, HttpStatus.BAD_REQUEST, "Bad query");
    }

    public static MapsApiException wrap(Exception exception) {
        return wrap(exception, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    }

    private static MapsApiException wrap(Exception exception, HttpStatus httpStatus, String message) {
        MapsApiException mapsApiException = newException(httpStatus, message);
        mapsApiException.initCause(exception);
        return mapsApiException;
    }

    public static MapsApiException notFound() {
        return newException(HttpStatus.NOT_FOUND, "One or more objects were not found");
    }

    private static MapsApiException newException(HttpStatus httpStatus, String message) {
        return new MapsApiException(httpStatus, message);
    }
}
