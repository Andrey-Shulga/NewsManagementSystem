package com.epam.testapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final String DATE_PATTERN = "EE MMM dd HH:mm:ss z yyyy";

    public static Date getFormatDate(String source){

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;

    }
}
