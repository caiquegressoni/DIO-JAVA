import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        var date = new Date();
        System.out.println(date.getTimezoneOffset() / 60 );
    }
}
/*
Code 1:
      var formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");

        System.out.println(date); //Por padrão retorna a data atual
        System.out.println(formatter.format(date));

Code 2:
        var milliSeconds = System.currentTimeMillis();
        var date = new Date(milliSeconds);
        var newDate = new Date(milliSeconds);
        System.out.println(date.equals(newDate));
*/