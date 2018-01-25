package BouncyCastle;

import Algorithms.Algorithm;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

public class AesBC extends Algorithm {

    public AesBC(Integer keySize, String mode, String padding) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        // set Cipher
        Security.addProvider(new BouncyCastleProvider());
        if (mode == null || mode.equals("")) {
            this.cipher = Cipher.getInstance("AES", "BC");
        }
        else {
            this.cipher = Cipher.getInstance("AES/" + mode + "/" + padding, "BC");
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
