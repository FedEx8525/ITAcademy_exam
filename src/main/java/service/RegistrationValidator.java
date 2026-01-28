package service;

import exceptions.InvalidPasswordException;
import exceptions.NotNullNameException;

public class RegistrationValidator implements UserValidator{

    @Override
    public void validate(String name, String password) {
        if (name == null || name.trim().isEmpty()) {
            throw new NotNullNameException();
        }
        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException();
        }
    }
}
