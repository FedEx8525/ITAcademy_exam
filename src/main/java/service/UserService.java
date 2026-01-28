package service;

import exceptions.InvalidPasswordException;
import exceptions.NotNullNameException;
import models.User;
import exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private final Set<User> usersSet = new HashSet<>();
    private final UserValidator validator;

    public UserService(UserValidator validator) {
        this.validator = validator;
    }
    public void register(String name, String password) {
        validator.validate(name, password);

        checkUserUniqueness(name);

        saveUser(new User(name, password));
    }

    private void checkUserUniqueness(String name) {
        if (existsByName(name)) {
            throw new UserAlreadyExistsException();
        }
    }

    private void saveUser(User newUser) {
        usersSet.add(newUser);
    }

    private boolean existsByName(String name) {
        return usersSet.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(name));
    }


    public int getUsersCount() {
        return usersSet.size();
    }
}
