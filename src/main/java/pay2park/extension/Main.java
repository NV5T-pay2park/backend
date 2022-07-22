package pay2park.extension;

import java.time.Instant;
import java.util.Optional;

public class Main {
    public static String getTime() {
        String time2 = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' + Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        String time = Instant.parse(time2).toString();
        return time;
    }

    public static void main(String []args) {
        Integer a = null;
        Optional<Integer> check = Optional.of(a);
        System.out.println(check.get());
    }
}
