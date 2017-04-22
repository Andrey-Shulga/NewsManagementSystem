package com.epam.testapp.util;

import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("DateConverter");
    private static final String NEW_DATE_PATTERN = "EE MMM dd HH:mm:ss z yyyy";
    private static final String FROM_BASE_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date getNewDate(String source){

        Date formatDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(NEW_DATE_PATTERN, Locale.ENGLISH);
            formatDate = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;

    }

    public static Date getFromBaseDate(String source){

        Date formatDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(FROM_BASE_DATE_PATTERN, Locale.ENGLISH);
            formatDate = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;

    }
}
