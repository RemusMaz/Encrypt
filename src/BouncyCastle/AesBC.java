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

    public AesBC(Integer keySize) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        this.cipher = Cipher.getInstance("AES", "BC");

        KeyGenerator keygen = KeyGenerator.getInstance("AES") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();

        this.key = new SecretKeySpec(key, "AES");
    }
}
