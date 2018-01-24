package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class AES extends Algorithm {
    public AES() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("AES");
        this.key = new SecretKeySpec(this.keyBytes, "AES");
    }
}
