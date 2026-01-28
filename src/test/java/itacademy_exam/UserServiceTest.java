package itacademy_exam;

import exceptions.InvalidPasswordException;
import exceptions.NotNullNameException;
import exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {

    private UserService userService;
    private UserValidatorStub validatorStub;

    @BeforeEach
    void setUp() {

        validatorStub = new UserValidatorStub();
        userService = new UserService(validatorStub);

    }

    @Test
    void shouldRegisterUserWhenValidationIsOk() {
        validatorStub.setExceptionToThrow(null);

        userService.register("Federico", "pass12345");

        assertEquals(1, userService.getUsersCount());
    }

    @Test
    void shouldFailWhenValidatorReturnsNotNullName() {
        // No nos importa el valor real, forzamos la excepción que queremos probar
        validatorStub.setExceptionToThrow(new NotNullNameException());

        assertThrows(NotNullNameException.class, () -> {
            userService.register("NoImporta", "NoImporta");
        });
    }

    @Test
    void shouldFailWhenValidatorReturnsInvalidPassword() {
        validatorStub.setExceptionToThrow(new InvalidPasswordException());

        assertThrows(InvalidPasswordException.class, () -> {
            userService.register("Federico", "123");
        });
    }

    @Test
    void shouldFailWhenUserAlreadyExistsInSet() {
        validatorStub.setExceptionToThrow(null); // La validación pasa
        userService.register("Federico", "pass123");

        // El segundo intento debe lanzar la excepción de duplicado
        assertThrows(UserAlreadyExistsException.class, () -> {
            userService.register("Federico", "otraPass");
        });
    }

}
