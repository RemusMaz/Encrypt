package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class RC2 extends Algorithm {
    public RC2() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RC2");
        this.key = new SecretKeySpec(this.keyBytes, "RC2");

    }
}
