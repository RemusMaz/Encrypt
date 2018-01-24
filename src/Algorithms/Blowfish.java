package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class Blowfish extends Algorithm {
    public Blowfish() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("Blowfish");
        this.key = new SecretKeySpec(this.keyBytes, "Blowfish");

    }
}
