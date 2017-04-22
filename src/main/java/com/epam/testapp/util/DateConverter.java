package com.epam.testapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final String FROM_BASE_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date getStrToDate(String source){

        Date formatDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(FROM_BASE_DATE_PATTERN);
            formatDate = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;

    }

    public static String getDateToStr(Date date){

        SimpleDateFormat dateFormat = new SimpleDateFormat(FROM_BASE_DATE_PATTERN);
        return dateFormat.format(date);
    }
}
