import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        offsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);

        System.out.println(offsetDateTime);

        var date = Date.from(offsetDateTime.toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println(date);


        OffsetDateTime offsetDateTime1 = Calendar.getInstance().getTime()
                .toInstant().atOffset(ZoneOffset.ofHours(-3));
        System.out.println(offsetDateTime1);
    }
}
/*
Code 1:
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(formatter.format(localDateTime));

        localDateTime.toInstant(ZoneOffset.ofHours(-3));

        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println(date);

Code 2:
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        System.out.println(localDateTime);
        System.out.println(Duration.between(localDateTime, LocalDateTime.now()).toMillis());
*/