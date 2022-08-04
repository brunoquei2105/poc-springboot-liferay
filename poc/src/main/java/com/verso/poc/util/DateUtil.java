package com.verso.poc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil() {
    }

    public static String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    public static String getCurrentDate(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    public static String formatDate(String newPattern, String curentPattern, String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(curentPattern);
        DateFormat formatter1 = new SimpleDateFormat(newPattern);
        return formatter1.format(formatter.parse(date));
    }

    public  static LocalDateTime subtractFromLocalDateTime(LocalDateTime date, long months){
        return date.minusMonths(months);
    }
}