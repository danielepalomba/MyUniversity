package myUniversityPack.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeService {

    public static Timestamp getTime(String year, String month, String day){
        LocalTime t = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), t.getHour(), t.getMinute());
        return  Timestamp.valueOf(localDateTime);
    }
}
