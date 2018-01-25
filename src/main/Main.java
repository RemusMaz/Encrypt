package main;

import Algorithms.Algorithm;
import Algorithms.AlgorithmFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Main {

    public static void main(String[] args) {

        AlgorithmFactory factory = new AlgorithmFactory();

        try {
            byte[] data = "toti algoritmii de criptare fac acelasi lucru, are you mad?".getBytes("UTF-8");

            testAlgorithm("AES", data, new int[]{128, 192, 256}, new String[]{"CBC", "OFB", "CFB", "CTR"});
            testAlgorithm("AESBC", data, new int[]{128, 192, 256}, new String[]{"CBC", "OFB", "CFB", "CTR"});
            testAlgorithm("Blowfish", data, new int[]{128, 192, 256}, new String[]{"CBC", "OFB", "CFB", "CTR"});
            testAlgorithm("BlowfishBC", data, new int[]{128, 192, 256}, new String[]{"CBC", "OFB", "CFB", "CTR"});
            testAlgorithm("RC2", data, new int[]{64, 128}, new String[]{"CBC", "OFB", "CFB", "CTR"});
            testAlgorithm("RC2BC", data, new int[]{64, 128}, new String[]{"CBC", "OFB", "CFB", "CTR"});

            testRC4("RC4", data, new int[]{128, 192, 256, 512, 1024});
            testRC4("RC4BC", data, new int[]{128, 192, 256, 512, 1024});

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }

    public static void computeTime(String message, long startTime) {
        System.out.println(message + " - Total Time: " + (System.nanoTime() - startTime) / 1000000 + "s");
    }

    public static void testAlgorithm(String algorithmName, byte[] data, int[] keySizes, String[] modes)
            throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        AlgorithmFactory factory = new AlgorithmFactory();
        byte[] cipherData;
        byte[] dataD;

        for (int keySize : keySizes) {
            for (String mode : modes) {
                Algorithm aes = factory.getAlgorithm(algorithmName, keySize, mode, "PKCS5Padding");

                long time = System.nanoTime();
                cipherData = aes.encrypt(data);
                computeTime(algorithmName + " " + keySize + "key with mode " + mode + " encrypt", time);

                time = System.nanoTime();
                dataD = aes.decrypt(cipherData);
                computeTime(algorithmName + " " + keySize + "key with mode " + mode + " decrypt", time);

                System.out.println(new String(cipherData));
                System.out.println(new String(dataD));
            }
        }

    }

    public static void testRC4(String algorithmVariation, byte[] data, int[] keySizes)
            throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        AlgorithmFactory factory = new AlgorithmFactory();
        byte[] cipherData;
        byte[] dataD;
        for (int keySize : keySizes) {
            Algorithm rc4 = factory.getAlgorithm(algorithmVariation, keySize, "", "");

            long time = System.nanoTime();
            cipherData = rc4.encrypt(data);
            computeTime(algorithmVariation + " " + keySize + "key encrypt", time);

            time = System.nanoTime();
            dataD = rc4.decrypt(cipherData);
            computeTime(algorithmVariation + " " + keySize + "key decrypt", time);

            System.out.println(new String(cipherData));
            System.out.println(new String(dataD));
        }
    }
}
