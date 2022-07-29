package pay2park.extension;

import java.time.Instant;
import java.util.Optional;

import static pay2park.extension.Extension.getLicensePlate;

public class Main {
    public static String getTime() {
        String time2 = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' + Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        String time = Instant.parse(time2).toString();
        return time;
    }

    public static void main(String []args) {
        System.out.println(getLicensePlate());
    }
}
