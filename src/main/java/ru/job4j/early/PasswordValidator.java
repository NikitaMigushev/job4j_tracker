package ru.job4j.early;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (!isBetween8And32Char(password)) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        checkCharacters(password);
        if (hasSubstringQwerty(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean isBetween8And32Char(String pass) {
        return pass.length() > 8 && pass.length() < 32;
    }

    private static void checkCharacters(String pass) {
        boolean hasUpperCaseLetter = false;
        boolean hasLowerLatinLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;
        for (char ch : pass.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowerLatinLetter = true;
            }
            if (Character.isUpperCase(ch)) {
                hasUpperCaseLetter = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                hasSpecialSymbol = true;
            }
            if (hasUpperCaseLetter && hasLowerLatinLetter && hasDigit && hasSpecialSymbol) {
                break;
            }
        }
        if (!hasUpperCaseLetter) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerLatinLetter) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
    }

    private static boolean hasSubstringQwerty(String pass) {
        boolean result = false;
        String[] patterns = {"qwerty", "12345", "password", "admin", "user"};
        for (String pattern : patterns) {
            result = Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE).matcher(pass).find();
            if (result) {
                break;
            }
        }
        return result;
    }
}

