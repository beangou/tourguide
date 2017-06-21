package com.tourguide.common;

/**
 * Created by liutongbin on 2017/4/5.
 */
public class TourguideException extends RuntimeException {

    public TourguideException() {
        super();
    }

    public TourguideException(String message) {
        super(message);
    }

    public TourguideException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourguideException(Throwable cause) {
        super(cause);
    }

}
