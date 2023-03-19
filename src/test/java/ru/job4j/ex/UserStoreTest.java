package ru.job4j.ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {

    @Test
    void whenFindUserIsFound() {
        User[] users = {new User("Nikita Migushev", true)};
        User result = null;
        try {
            result = UserStore.findUser(users, "Nikita Migushev");
        } catch (UserNotFoundException unf) {
            unf.getStackTrace();
        }
        User expected = new User("Nikita Migushev", true);
        Assertions.assertThat(result.getUsername()).isEqualTo("Nikita Migushev");
    }

    @Test
    void whenFindUserNotFound() {
        User[] users = {new User("Nikita Migushev", true)};
        User result = null;
        try {
            result = UserStore.findUser(users, "Nikita");
        } catch (UserNotFoundException unf) {
            unf.getStackTrace();
        }
        User expected = new User("Nikita Migushev", true);
        Assertions.assertThat(result).isNull();
    }

    @Test
    void whenFindUserException() {
        User[] users = {new User("Nikita Migushev", true)};
        UserNotFoundException exception = assertThrows(
                UserNotFoundException.class,
                () -> {
                    UserStore.findUser(users, "Nikita");
                }
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo("User Nikita has not been found");
    }

    @Test
    void whenValidateTrue() {
        User user = new User("Nikita Migushev", true);
        boolean result = false;
        try {
            result = UserStore.validate(user);
        } catch (UserInvalidException uinv) {
            uinv.getStackTrace();
        }
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void whenValidateFalse() {
        User user = new User("Ni", true);
        boolean result = false;
        try {
            result = UserStore.validate(user);
        } catch (UserInvalidException uinv) {
            uinv.getStackTrace();
        }
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void whenValidateStateFalse() {
        User user = new User("Nikita Migushev", false);
        boolean result = false;
        try {
            result = UserStore.validate(user);
        } catch (UserInvalidException uinv) {
            uinv.getStackTrace();
        }
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void whenValidateException() {
        User user = new User("Nikita Migushev", false);
        UserInvalidException exception = assertThrows(
                UserInvalidException.class,
                () -> {
                    UserStore.validate(user);
                }
        );
        Assertions.assertThat(exception.getMessage()).isEqualTo("Username is not valid");
    }
}