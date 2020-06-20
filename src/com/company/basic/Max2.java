package com.company.basic;

public class Max2 {

    public static void main(String[] args) {

        int max = findByMax(10 , 11 , 15);
        System.out.println("Max Value is :: " + max);

    }

    public static int findByMax(int a, int b, int c) {

        int max = a;

        if (b > max) max = b;

        if (c > max) max = c;

        return max;

    }

}
