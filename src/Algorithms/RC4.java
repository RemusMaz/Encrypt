package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class RC4 extends Algorithm {
    public RC4(Integer keySize) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RC4");

        KeyGenerator keygen = KeyGenerator.getInstance("RC4") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();
        this.key = new SecretKeySpec(key, "RC4");

    }
}
