package itacademy_exam;

import service.UserValidator;

public class UserValidatorStub implements UserValidator {

    private RuntimeException exceptionTOThrow = null;

    public void setExceptionToThrow(RuntimeException exception) {
        this.exceptionTOThrow = exception;
    }

    @Override
    public void validate(String name, String password){
        if (exceptionTOThrow != null) {
            throw exceptionTOThrow;
        }

    }
}
