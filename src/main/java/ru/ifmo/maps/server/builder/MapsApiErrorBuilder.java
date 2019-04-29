package ru.ifmo.maps.server.builder;

import ru.ifmo.maps.server.exception.MapsApiError;
import ru.ifmo.maps.server.exception.MapsApiException;

public class MapsApiErrorBuilder {

    public static MapsApiError build(MapsApiException exception) {
        MapsApiError error = new MapsApiError();
        String message = exception.getMessage();
        if (message == null) {
            error.setMessage("Internal API Exception");
        } else {
            error.setMessage(message);
        }
        return error;
    }

}
