package com.example.silkroad;

import java.util.Random;

public class MakeRandomCaptcha {
    private String characters = "0123456789qwertyuiopasdfghjkzxcvbnmQWERTYUOPASDFGHJKLZXCVBNM";

    Random random = new Random();

    private String generateCaptcha()
    {
        char[] captcha = new char[5];
        for (int i = 0; i < 5; i++)
        {
            captcha[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(captcha);
    }

    public String getRandomCaptcha() {
        return (generateCaptcha());
    }

}
