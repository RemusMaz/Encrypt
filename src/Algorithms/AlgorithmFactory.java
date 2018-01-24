package Algorithms;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class AlgorithmFactory {
    public Algorithm getAlgorithm(String algorithmName) throws NoSuchAlgorithmException, NoSuchPaddingException {

        if (algorithmName == "AES" ){
            return new AES();
        }
        if (algorithmName == "Blowfish" ){
            return new Blowfish();
        }
        if (algorithmName == "RC4" ){
            return new RC4();
        }
        if (algorithmName == "RC2" ){
            return new RC2();
        }

        return null;
    }
}
