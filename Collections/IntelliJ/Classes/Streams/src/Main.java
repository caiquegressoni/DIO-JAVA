import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> values1 = List.of(1,2,4,122);
        List<Integer> values2 = List.of(1,2,4,12,22,66,44);

        var newValues = values2.stream().filter(values1::contains)
                .map(n -> values1.stream().reduce(n, (n1, n2) -> n1 - n2))
                .collect(Collectors.toSet());
        System.out.println(newValues);
    }
}


/*  Code 1:
    var value1 = Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray(Integer[]::new);

        for(var v : value1) {
            System.out.println(v);
        }

        System.out.println("============================");

        var value2 = IntStream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray();

        for(var v : value2){
            System.out.println(v);
        }
Code 2:
        var value = Stream.of(1, 2, 3, 4, 5 ,5, 1, 4)
                .map(n -> n % 2 == 0)
                .toList();
        System.out.println(value);
*/