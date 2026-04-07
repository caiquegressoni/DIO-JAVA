import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        var value1 = new BigDecimal( "3.1");
        var value2 = new BigDecimal("1.2");

        System.out.println(BigDecimal.ONE);
    }
}
/*
* BigDecimal é mais preciso que os objetos como Float e Double
* Para realizar a divião com BigDecimal é recomendado utiliza o RoundingMode, exemplo:
* System.out.println(value1.divide(value2, 2,RoundingMode.HALF_UP));
* */