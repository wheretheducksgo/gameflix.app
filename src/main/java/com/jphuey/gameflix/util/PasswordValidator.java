package com.jphuey.gameflix.util;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null) return false;
        if (password.length() < 6) return false;
        if (!password.matches(".*[A-Z].*")) return false;  // at least one uppercase
        if (!password.matches(".*[a-z].*")) return false;  // at least one lowercase
        if (!password.matches(".*\\d.*")) return false;    // at least one digit
        return true;
    }
}