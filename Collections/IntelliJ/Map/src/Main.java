import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("joao@joao.com", new User("Joao", 33));
        users.put("maria@maria.com", new User("Maria", 22));
        users.put("tarcisio@tarcisio.com", new User("Tarcisio", 45));
        users.put("eneas@eneas.com", new User("Eneas", 50));
        System.out.println(users);
        System.out.println("============================================");
        users.keySet().forEach(System.out::println);
        System.out.println("============================================");
        users.values().forEach(System.out::println);
        System.out.println("============================================");
        System.out.println(users.get("maria@maria.com"));
        System.out.println("============================================");
        users.merge("eneas@eneas.com", new User("Eneas", 55), (user, user2) ->{
            System.out.println(user);
            System.out.println(user2);
            return user2;
        });
        System.out.println(users);
        System.out.println("============================================");
        //Remove/Replace
        users.replace("joao@joao.com", new User("João", 33));
        users.forEach((k, v) -> System.out.printf("key: %s | value: %s \n", k, v));
        System.out.println("============================================");
        users.remove("tarcisio@tarcisio.com", new User("Tarcisio", 45));
        System.out.println(users);
        //Inputa novo valor
        users.putIfAbsent("zezinho@zezinho", new User("Zézinho", 20));
        System.out.println(users);
    }
}
/*Função Merge == Replace
*Função putIfAbsent() -> Inputar novo valor na lista caso nao exista
**/