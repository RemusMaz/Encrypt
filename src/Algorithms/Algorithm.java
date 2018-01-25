package Algorithms;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;

public class Algorithm {
    public byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    public Key key = null;
    public Cipher cipher = null;

    public byte[] encrypt(byte[] data) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, this.key);
        byte[] cipherText = cipher.doFinal(data);

        return cipherText;
    }

    public byte[] decrypt(byte[] data) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, this.key);
        byte[] cipherText = cipher.doFinal(data);

        return cipherText;
    }
}
