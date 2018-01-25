package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class RC2 extends Algorithm {
    public RC2(Integer keySize, String mode, String padding) throws NoSuchPaddingException, NoSuchAlgorithmException {
        // set Cipher
        if (mode == null || mode.equals("")) {
            this.cipher = Cipher.getInstance("RC2");
        }
        else {
            this.cipher = Cipher.getInstance("RC2/" + mode + "/" + padding);
        }

        // set IV
        generateIvParams();

        // set Key
        KeyGenerator keygen = KeyGenerator.getInstance("RC2") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();

        this.key = new SecretKeySpec(key, "RC2");

    }
}
