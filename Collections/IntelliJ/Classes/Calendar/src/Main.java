import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws ParseException {
        var calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss - Z");
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(formatter.format(calendar.getTime()));

        var stringDate = formatter.format(calendar.getTime());
        System.out.println(stringDate);

        var intDate = formatter.parse(stringDate);
        System.out.println(intDate);
    }
}
