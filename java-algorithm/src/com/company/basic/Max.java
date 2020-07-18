package com.company.basic;

import java.util.Scanner;

public class Max {

    /**
     * Find Max Value
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("세 정수의 최대값을 구하여라 ");

        System.out.println("a의 값은 ? :: ");
        int a = scanner.nextInt();

        System.out.println("b의 값은 ? :: ");
        int b = scanner.nextInt();

        System.out.println("c의 값은 ? :: ");
        int c = scanner.nextInt();

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("Max Data is " + max);

    }

}
