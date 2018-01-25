package Algorithms;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class RC4 extends Algorithm {
    public RC4(Integer keySize, String mode, String padding) throws NoSuchPaddingException, NoSuchAlgorithmException {
        // set Cipher
        if (mode == null || mode.equals("")) {
            this.cipher = Cipher.getInstance("RC4");
        }
        else {
            this.cipher = Cipher.getInstance("RC4/" + mode + "/" + padding);
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
