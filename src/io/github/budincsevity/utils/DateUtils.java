package io.github.budincsevity.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateUtils {
    public static long getEpochOf(int year, Month month, int day) {
        LocalDate forecastedDate = LocalDate.of(year, month, day);
        ZoneId zoneId = ZoneId.systemDefault();

        return forecastedDate.atStartOfDay(zoneId).toEpochSecond();
    }

    public static List<Month> months() {
        return Arrays.asList(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE,
                Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
    }

    public static String formatDate(long time) {
        Date date = new Date(time * 1000L);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");

        return formatter.format(date);
    }
}
