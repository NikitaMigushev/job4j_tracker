package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user != null && user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User " + login + " has not been found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null || user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Username is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr", true)
        };

        User user = null;
        try {
            user = findUser(users, "Petra");
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException unv) {
            unv.printStackTrace();
        }
    }
}
