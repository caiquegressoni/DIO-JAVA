import java.time.Duration;
import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        var builderString = new StringBuilder("1234567890");
        System.out.println(builderString);
    }
}
/*Teste de eficiencia em memoria de cada tipo de String
*
        var stringStart = OffsetDateTime.now();
        String st = " ";
        for(int i = 0; i < 200_000; i++){
            st += i;
        }
        var stringEnd = OffsetDateTime.now();
        System.out.printf("String: %s \n", getInterval(stringStart, stringEnd));

        var stringBufferStart = OffsetDateTime.now();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 200_000; i++) {
            stringBuffer.append(i);
        }
        var stringBufferEnd = OffsetDateTime.now();
        System.out.printf("StringBuffer(Multithread): %s\n", getInterval(stringBufferStart, stringBufferEnd));

        var stringBuilderStart = OffsetDateTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 200_000; i++) {
            stringBuilder.append(i);
        }
        var stringBuilderEnd = OffsetDateTime.now();
        System.out.printf("StringBuilder: %s\n", getInterval(stringBuilderStart, stringBuilderEnd));

        private static long getInterval(final OffsetDateTime stringStart, final OffsetDateTime stringEnd){
        return Duration.between(stringStart, stringEnd).toMillis();
    }
* */
