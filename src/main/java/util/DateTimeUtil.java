package util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private DateTimeUtil() { }

    public static String getDatePlusDays (String date, int numberOfDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDateTime formattedDate = LocalDateTime.of(parsedDate, midnight);
        return LocalDateTime.from(formattedDate.plusDays(numberOfDays)).format(formatter);
    }

}
