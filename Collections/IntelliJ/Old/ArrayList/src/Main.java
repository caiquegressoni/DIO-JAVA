import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        var arrayStart = OffsetDateTime.now();
        for (int i = 0; i < 100_000; i++) {
            array.add(i);
        }
        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        List<Integer> vector = new Vector<>();
        var vectorStart = OffsetDateTime.now();
        for (int i = 0; i < 100_000; i++) {
            vector.add(i);
        }
        System.out.println(Duration.between(vectorStart, OffsetDateTime.now()).toMillis());
    }
            /*List<User> users = new ArrayList<>();

        var user = new User(1, "João");
        users.add(user);
        System.out.println(users.contains(user));

        users.add(new User(2, "Maria"));
        users.add(new User(3, "Bento"));

        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getLast());

        System.out.println(new User(1, "João").equals(new User(1, "João")));

        System.out.println(users);
        System.out.println(users.removeFirst());
        users.clear();
        System.out.println(users);*/
}
