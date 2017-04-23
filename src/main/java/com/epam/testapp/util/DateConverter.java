package com.epam.testapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

    public static Date getStrToDate(String source){

        Date formatDate = null;
        try {
            formatDate = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;

    }

    public static String getDateToStr(Date date){

        return dateFormat.format(date);
    }
}
