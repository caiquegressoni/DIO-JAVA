import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] codes = {761, 541};

        List<Integer> codes2 = new ArrayList<>();
        codes2.add(codes[0]);
        codes2.add(codes[1]);
        codes2.forEach(System.out::println);
        codes2.add(999);
        codes2.forEach(System.out::println);


    }
}
