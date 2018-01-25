package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class RC2 extends Algorithm {
    public RC2(Integer keySize) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RC2");

        KeyGenerator keygen = KeyGenerator.getInstance("RC2") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();

        this.key = new SecretKeySpec(key, "RC2");

    }
}
