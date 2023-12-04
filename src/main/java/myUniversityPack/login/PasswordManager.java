package myUniversityPack.login;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PasswordManager {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "my_secret_key1234560g0lg";
    private static final String CHARSET = "UTF-8";

    public static String encryptPassword(String password) {
        try {
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes(CHARSET));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptPassword(String encryptedPassword) {
        try {
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new String(decryptedBytes, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

