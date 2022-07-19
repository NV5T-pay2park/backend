package pay2park.extension;

import java.time.Instant;

public class Main {
    public static String getTime() {
        String time2 = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' + Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        String time = Instant.parse(time2).toString();
        return time;
    }

    public static void main(String []args) {
        System.out.println(getTime());
    }
}
