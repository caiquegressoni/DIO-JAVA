import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var user = new User("Jonas", 20);

        int i = 0;
        printValues(user);
        System.out.println(user);
    }
    private static void printValues(final User user){
        user.setName("Marcia");
        user.setAge(40);
        System.out.println(user);
    }
}
