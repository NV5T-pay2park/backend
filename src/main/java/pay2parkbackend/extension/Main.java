package com.example.pay2parkbackend.extension;

import java.sql.Time;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.TimeZone;

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
