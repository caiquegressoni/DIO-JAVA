import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        var user = new User("Faizao", "faiza@faiao.com", 45, 1);
        users.add(new User("Franco", "franco@franco.com", 20, 2));
        users.add(new User("Leo", "leo@franco.com", 20, 3));
        users.add(user);

        System.out.println(users.contains(user));
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getFirst());
        System.out.println(users.getLast());
    }
}
