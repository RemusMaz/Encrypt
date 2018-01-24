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

            byte[] cipherData;
            byte[] dataD;

            cipherData = aes.encrypt(data);
            dataD = aes.decrypt(cipherData);

            System.out.println(new String(cipherData));
            System.out.println(new String(dataD));

            cipherData = rc4.encrypt(data);
            dataD = rc4.decrypt(cipherData);


            System.out.println(new String(cipherData));
            System.out.println(new String(dataD));
//            System.out.println(new String(cipherDataRc4));
//            System.out.println(new String(cipherDataCcm));


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
