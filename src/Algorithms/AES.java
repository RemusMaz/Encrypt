package Algorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class AES extends Algorithm {
    public AES(Integer keySize, String mode, String padding) throws NoSuchPaddingException, NoSuchAlgorithmException {
        // set Cipher
        if (mode == null || mode.equals("")) {
            this.cipher = Cipher.getInstance("AES");
        }
        else {
            this.cipher = Cipher.getInstance("AES/" + mode + "/" + padding);
        }

        // set IV
        generateIvParams();

        // set Key
        KeyGenerator keygen = KeyGenerator.getInstance("AES") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();
        this.key = new SecretKeySpec(key, "AES");
    }
}
