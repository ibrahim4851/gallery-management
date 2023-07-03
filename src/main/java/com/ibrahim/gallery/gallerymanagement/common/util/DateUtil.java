package com.ibrahim.gallery.gallerymanagement.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public final class DateUtil {

    public static Date getNowDate() {
        return new Date();
    }

    public static String format(Date date, String formatPattern) {

        if (Objects.nonNull(date)) {
            SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
            return formatter.format(date);
        }

        return " ";
    }

    public static Date convertToDate(String dateString, String formatPattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        return formatter.parse(dateString);
    }

    public static Date setDay(int day) {

        Date date = getNowDate();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }

    public static Date setTime(Date date, int hour, int minute, int second, int millisecond) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);

        return calendar.getTime();
    }

    public static Date setSecondAndMillisecond(Date date, int second, int millisecond) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);

        return calendar.getTime();
    }

}
