package BouncyCastle;

import Algorithms.Algorithm;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;


public class AesBC extends Algorithm {

    public AesBC() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        this.cipher = Cipher.getInstance("AES", "BC");
        this.key = new SecretKeySpec(this.keyBytes, "AES");
    }
}
