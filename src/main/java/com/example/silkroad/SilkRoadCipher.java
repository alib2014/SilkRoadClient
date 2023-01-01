package com.example.silkroad;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class SilkRoadCipher {
    private final String encryptionKeyString = "SilkRoadOfficial";
    private final byte[] encryptedKeyBytes = Base64.getDecoder().decode(encryptionKeyString);
    Cipher cipher;
    SecretKey secretKey = new SecretKeySpec(Arrays.copyOf(encryptedKeyBytes, 16), "AES");
    {
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public String doEncrypt(String data) {
        try {
            byte[] encryptedByteData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedByteData);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public String doDecrypt(String data) {
        try {
            byte[] decryptedByteData = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decryptedByteData);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
