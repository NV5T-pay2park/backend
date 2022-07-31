package pay2park.extension;

import java.text.SimpleDateFormat;
import java.time.Instant;
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
        Date myDate = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatter.setCalendar(new GregorianCalendar(TimeZone.getTimeZone("GMT+7")));
        return formatter.format(myDate);
    }
}
