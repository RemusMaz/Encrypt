package BouncyCastle;

import Algorithms.Algorithm;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class RC4BC extends Algorithm {
    public RC4BC(Integer keySize, String mode, String padding) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        // set Cipher
        Security.addProvider(new BouncyCastleProvider());
        if (mode == null || mode.equals("")) {
            this.cipher = Cipher.getInstance("RC4", "BC");
        }
        else {
            this.cipher = Cipher.getInstance("RC4/" + mode + "/" + padding, "BC");
        }

        // set IV
        generateIvParams();

        // set Key
        KeyGenerator keygen = KeyGenerator.getInstance("RC4") ;
        keygen.init(keySize) ;

        byte[] key = keygen.generateKey().getEncoded();
        this.key = new SecretKeySpec(key, "RC4");
    }

    @Override
    public byte[] encrypt(byte[] data) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        cipher.init(Cipher.ENCRYPT_MODE, this.key);
        byte[] cipherText = cipher.doFinal(data);

        return cipherText;
    }

    @Override
    public byte[] decrypt(byte[] data) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        cipher.init(Cipher.DECRYPT_MODE, this.key);
        byte[] cipherText = cipher.doFinal(data);

        return cipherText;
    }
}
