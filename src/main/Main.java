package main;

import Algorithms.Algorithm;
import Algorithms.AlgorithmFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        AlgorithmFactory factory = new AlgorithmFactory();

        try {
            byte[] data = "toti algoritmii de criptare fac acelasi lucru, are you mad?".getBytes("UTF-8");

            Algorithm aes = factory.getAlgorithm("AES");
            Algorithm rc4 = factory.getAlgorithm("RC4");
            Algorithm ccm = factory.getAlgorithm("RC5");

            byte[] cipherDataAes = aes.encrypt(data);
            byte[] cipherDataRc4 = rc4.encrypt(data);
            byte[] cipherDataCcm = ccm.encrypt(data);

            System.out.println(new String(cipherDataAes));
            System.out.println(new String(cipherDataRc4));
            System.out.println(new String(cipherDataCcm));


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

}
