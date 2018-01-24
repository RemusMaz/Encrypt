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
        if (algorithmName == "CCM" ){
            return new CCM();
        }
        if (algorithmName == "RC4" ){
            return new RC4();
        }
        if (algorithmName == "RC5" ){
            return new RC5();
        }

        return null;
    }
}
