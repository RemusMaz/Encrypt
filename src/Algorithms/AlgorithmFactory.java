package Algorithms;

import BouncyCastle.AesBC;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithmName, Integer keySize) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {

        if (algorithmName == "AES" ){
            return new AES(keySize);
        }
        if (algorithmName == "Blowfish" ){
            return new Blowfish(keySize);
        }
        if (algorithmName == "RC4" ){
            return new RC4(keySize);
        }
        if (algorithmName == "RC2" ){
            return new RC2(keySize);
        }
        if (algorithmName == "AESBC" ) {
            return new AesBC(keySize);
        }

        return null;
    }
}
