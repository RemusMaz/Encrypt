package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class AES extends Algorithm {
    public AES(Integer keySize) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("AES");

        KeyGenerator keygen = KeyGenerator.getInstance("AES") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();
        this.key = new SecretKeySpec(key, "AES");
    }
}
