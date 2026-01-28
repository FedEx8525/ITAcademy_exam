package itacademy_exam;

import exceptions.InvalidPasswordException;
import exceptions.NotNullNameException;
import exceptions.UserAlreadyExistsException;
import service.RegistrationValidator;
import service.UserService;
import service.UserValidator;

public class Main {
    public static void main(String[] args) {


        UserValidator validator = new RegistrationValidator();

        UserService userService = new UserService(validator);

        String[][] usersToRegister = {
                {"Federico", "FC123456"},
                {"Carlos", "CR1234"},
                {"", "RD12345678"},
                {"Federico", "FC123456"}
        };

        for(String[] userData : usersToRegister) {


            try {
                userService.register(userData[0], userData[1]);
                System.out.println("Registration Successful for " + userData[0]);
            } catch (NotNullNameException | UserAlreadyExistsException | InvalidPasswordException e) {
                System.out.println("Error registering " + userData[0] + ": " + e.getMessage());
            }
        }

    }
}
