package pay2park.extension;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
    public static String getLicensePlate() {
        return "77C1-12345";
    }
}