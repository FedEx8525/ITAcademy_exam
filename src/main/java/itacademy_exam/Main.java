package itacademy_exam;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<User> userList = new HashSet<User>();

        UserService service = new UserService(userList);

        try {
            service.register("Federico", "FC123456");
        } catch ()

        User user1 = new User("Federico", "FC123456" );
        User user2 = new User("Carlos", "CR1234");
        User user3 = new User("", "RD12345678" );
        User user4 = new User("Paul", "");



        UserService service = new UserService(Set<User> usersList);
    }
}
