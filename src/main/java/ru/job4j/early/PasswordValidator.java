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
        if (!hasUpperCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasLowerLatinLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (hasSubstringQwerty(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean isBetween8And32Char(String pass) {
        return pass.length() > 8 && pass.length() < 32;
    }

    private static boolean hasLowerLatinLetter(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLowerCase(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean hasUpperCaseLetter(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean hasDigit(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean hasSpecialSymbol(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isDigit(pass.charAt(i)) && !Character.isLetter(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean hasSubstringQwerty(String pass) {
        boolean result = false;
            result = (Pattern.compile(Pattern.quote("qwerty"), Pattern.CASE_INSENSITIVE).matcher(pass).find()
                    || Pattern.compile(Pattern.quote("12345"), Pattern.CASE_INSENSITIVE).matcher(pass).find()
                    || Pattern.compile(Pattern.quote("password"), Pattern.CASE_INSENSITIVE).matcher(pass).find()
                    || Pattern.compile(Pattern.quote("admin"), Pattern.CASE_INSENSITIVE).matcher(pass).find()
                    || Pattern.compile(Pattern.quote("user"), Pattern.CASE_INSENSITIVE).matcher(pass).find());
        return result;
    }
}

