package com.example.springjpa;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Jasypt {

    public static void main(String[] args) {
        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("park12345!");
        jasypt.setAlgorithm("PBEWithMD5AndDES");

        String encryptedText = jasypt.encrypt("1234");
        String plainText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText:  " + encryptedText);
        System.out.println("plainText:  " + plainText);
    }

}
