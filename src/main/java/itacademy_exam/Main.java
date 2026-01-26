package itacademy_exam;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<User> userList = new HashSet<User>();

        UserService service = new UserService(userList);

        try {
            service.register("Federico", "FC123456");
        } catch (NotNullNameException | UserAlreadyExistsException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user2 = new User("Carlos", "CR1234");
        } catch (NotNullNameException | UserAlreadyExistsException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user3 = new User("", "RD12345678" );

        } catch (NotNullNameException | UserAlreadyExistsException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user3 = new User("", "RD12345678" );

        } catch (NotNullNameException | UserAlreadyExistsException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
