package com.epam.testapp.exception;

import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class DateConverterException extends Exception {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("DateConverterException");

    public DateConverterException(ParseException e) {

        super(e);
        log.error("Wrong date format", e);
    }
}
