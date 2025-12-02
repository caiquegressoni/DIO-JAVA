import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Joao"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Zezinho"));
        users.add(new User(4, "Zezinha"));

        System.out.println(new User(1, "Joao").hashCode());
        System.out.println(users.contains(new User(1, "Joao")));

        //users.forEach(System.out::println);
        //Solução com while em vez de forEach

        /*var iterator = users.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        //System.out.println(users.removeAll(List.of(new User(1, "Joao"), new User(5, "Romario"))));
        //users.removeIf(user -> user.getId() == 1);
        users.removeIf(Predicate.not(user -> user.getId() > 1));
        System.out.println(users);
    }
}
/*
*O modelo do Set diferente do List, não permite duplicidades */
/*
* Aula de SET, minuto 27:31*/