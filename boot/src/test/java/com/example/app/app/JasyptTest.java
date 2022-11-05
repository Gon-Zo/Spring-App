package com.example.app.app;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

    public static void main(String[] args) {

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();

        String[] array = new String[]{
        };

        jasypt.setPassword("");

        jasypt.setAlgorithm("PBEWithMD5AndDES");

        for (String encrypt : array) {

            String encryptedText = jasypt.encrypt(encrypt);

            String plainText = jasypt.decrypt(encryptedText);

            System.out.println("encryptedText:  " + encryptedText);

            System.out.println("plainText:  " + plainText);
        }

    }

}
