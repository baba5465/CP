package com.baba;

import java.math.BigInteger;
import java.util.Scanner;

public class UseOfBigInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger b1 = scanner.nextBigInteger();
        BigInteger b2 = scanner.nextBigInteger();
        BigInteger b3 = (b1.subtract(b2)).divide(BigInteger.valueOf(2));
        System.out.println(b3);
        System.out.println(b3.add(b2));
    }
}
