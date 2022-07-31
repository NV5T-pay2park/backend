package pay2park.extension;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Extension {
    public static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }
    public static Instant getCurrentTimeInstant(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return Instant.parse(fmt.format(cal.getTimeInMillis()));
    }
    public static Instant getCheckInTime() {
        String time = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' +
                Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        return Instant.parse(time);
    }
    public static Instant getCheckOutTime() {
        String time = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' +
                Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        return Instant.parse(time);
    }

    public static String getLicensePlate() {
        Random random = new Random();
        int licensePlate = random.nextInt(90000) + 10000;
        int providerCode = random.nextInt(90) + 10;
        return providerCode + "C1-" + licensePlate;
    }
    public static String formatTime(Instant instant) {
        String dateTime = instant.toString();
        String date = dateTime.substring(0, 10);
        List<String> d = List.of(date.split("-"));
        date = d.get(2) + "/" + d.get(1) + "/" + d.get(0);
        String time = dateTime.substring(11, dateTime.length() - 1);
        dateTime = date + " " + time;
        return dateTime;
    }
}
