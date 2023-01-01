package com.example.silkroad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    private String text;

    public PasswordChecker(String text) {
        this.text = text;
    }

    public void checking() {
        /*
         3 or more digits small case letters
         2 or more digits upper case letters
         2 or more digits number
         1 or more digits of Special characters
        */
        Pattern pattern = Pattern.compile("^(?=(.*[a-z]){3,})(?=(.*[A-Z]){2,})(?=(.*[0-9]){2,})(?=(.*[!@#$%^&*()\\-_+.])+).{8,}$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Found");
        } else {
            System.out.println("Not found!");
        }

    }

}
