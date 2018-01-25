package Algorithms;

import BouncyCastle.AesBC;
import BouncyCastle.RC2BC;
import BouncyCastle.RC4BC;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithmName, Integer keySize, String mode, String padding)
            throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {

        if (algorithmName == "AES" ){
            return new AES(keySize, mode, padding);
        }
        if (algorithmName == "Blowfish" ){
            return new Blowfish(keySize, mode, padding);
        }
        if (algorithmName == "RC4" ){
            return new RC4(keySize, mode, padding);
        }
        if (algorithmName == "RC2" ){
            return new RC2(keySize, mode, padding);
        }
        if (algorithmName == "AESBC" ) {
            return new AesBC(keySize, mode, padding);
        }
        if (algorithmName == "BlowfishBC") {
            return new AesBC(keySize, mode, padding);
        }
        if (algorithmName == "RC2BC") {
            return new RC2BC(keySize, mode, padding);
        }
        if (algorithmName == "RC4BC") {
            return new RC4BC(keySize,mode, padding);
        }

        return null;
    }
}
