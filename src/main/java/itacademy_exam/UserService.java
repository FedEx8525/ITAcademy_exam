package itacademy_exam;

import java.util.Set;

import static java.util.Arrays.stream;

public class UserService {

    private Set<User> usersList;

    public UserService(Set<User> usersList) {
        this.usersList = usersList;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public void register(String name, String password) {

        if (name == null || name.trim().isEmpty()) {
            throw new NotNullNameException("Error: you must enter the name!");
        }

        if (existsByName(name)) {
            throw  new UserAlreadyExistsException("Error: the user you try to enter already exists!");
        }

        if(password == null || password.length() <= 8) {
            throw new InvalidPasswordException("Error: Password too short. Will must be minimum 8 character long!");
        }

        User newUser = new User(name, password);
        usersList.add(newUser);

    }

    private boolean existsByName(String name) {
        return usersList.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(name));
    }


}
