package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class RC4 extends Algorithm {
    public RC4() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RC4");
        this.key = new SecretKeySpec(this.keyBytes, "RC4");

    }
}
