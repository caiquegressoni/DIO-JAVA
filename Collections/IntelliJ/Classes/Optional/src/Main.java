import domain.UserV2;

import java.util.Optional;

import static domain.SexEnum.*;

public class Main {
    public static void main(String[] args) {
    Optional<User> optional = Optional.of(new User("Joao", 15, MALE));
    //Optional<User> optional = Optional.empty();
    optional.isEmpty();

    var newUser = optional.map(user -> new UserV2(user.name(), user.age(), user.sex())).orElseThrow();
        System.out.println(newUser);

        //System.out.println(optional.orElse(defaultUser()));
        //System.out.println(optional.orElseGet(Main::defaultUser));
    }
    public static User defaultUser() {
        System.out.println("Buscando valor default...");
        return new User("Maria", 39, FEMALE);
    }
}
/*
*
        optional.ifPresentOrElse(
                user -> {
                    System.out.println(user);
                    user = new User("Jose", 22, MALE);
                    System.out.println(user);
                },
                () -> System.out.println("Usuario nao encontrado!")
        );
* */