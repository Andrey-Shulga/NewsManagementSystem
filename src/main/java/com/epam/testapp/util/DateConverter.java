package com.epam.testapp.util;

import com.epam.testapp.exception.DateConverterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateConverter {


    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

    private DateConverter() {
    }

    public static Date getStrToDate(String source) throws DateConverterException {

        Date formatDate;
        try {
            formatDate = dateFormat.parse(source);
        } catch (ParseException e) {

            throw new DateConverterException(e);

        }
        return formatDate;

    }

    public static String getDateToStr(Date date){

        return dateFormat.format(date);
    }
}
