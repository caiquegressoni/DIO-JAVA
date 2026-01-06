import domain.Contact;
import domain.User;

import java.util.ArrayList;
import java.util.List;

import static domain.ContactType.EMAIL;
import static domain.ContactType.PHONE;
import static domain.Sex.MALE;

public class Main {
    public static void main(String[] args) {
    }

    private static List<User> generetUsers(){
        var contact1 = List.of(
                new Contact("", PHONE),
                new Contact("", EMAIL)
        );
        var contact2 = List.of(
                new Contact("", PHONE),
                new Contact("", EMAIL)
        );
        var contact3 = List.of(
                new Contact("", PHONE),
                new Contact("", EMAIL)
        );
        var contact4 = List.of(
                new Contact("", PHONE),
                new Contact("", EMAIL)
        );
        var contact5 = List.of(
                new Contact("", PHONE),
                new Contact("", EMAIL)
        );

        var user1 = new User("Jose", 34, MALE, new ArrayList<>(contact1));
        var user2 = new User("Jose", 34, MALE, new ArrayList<>(contact2));
        var user3 = new User("Jose", 34, MALE, new ArrayList<>(contact3));
        var user4 = new User("Jose", 34, MALE, new ArrayList<>(contact4));
        var user5 = new User("Jose", 34, MALE, new ArrayList<>(contact5));

        return List.of(user1, user2, user3, user4, user5);
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
Code 3:
        List<Integer> values1 = List.of(1,2,4,122);
        List<Integer> values2 = List.of(1,2,4,12,22,66,44);

        var newValues = values2.stream().filter(values1::contains)
                .map(n -> values1.stream().reduce(n, (n1, n2) -> n1 - n2))
                .collect(Collectors.toSet());
        System.out.println(newValues);
*/