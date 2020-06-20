package com.company.basic;

import java.util.Scanner;

/**
 *  정수와 양수 를 구분 하는 알고리즘
 *
 */
public class JudgeSign {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력하시요 ::");
        int n = scanner.nextInt();

        if (n > 0)
            System.out.println("양수 입니다");
        else if (n < 0)
            System.out.println("음수 입니다.");
        else
            System.out.println("0 입니다.");

    }

}
