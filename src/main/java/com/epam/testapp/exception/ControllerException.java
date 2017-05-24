package com.epam.testapp.exception;

import org.slf4j.LoggerFactory;

public class ControllerException extends Exception {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("ControllerException");

    public ControllerException(Exception e) {

        super(e);
        log.error("Wrong json format", e);

    }
}
