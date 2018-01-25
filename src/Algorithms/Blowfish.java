package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class Blowfish extends Algorithm {
    public Blowfish(Integer keySize) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("Blowfish");

        KeyGenerator keygen = KeyGenerator.getInstance("Blowfish") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();

        this.key = new SecretKeySpec(key, "Blowfish");

    }
}
