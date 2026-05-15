package Tests;

import java.math.BigInteger;
import java.util.Scanner;

public class test29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger count = new BigInteger(sc.nextLine());
        sc.close();
        System.out.println(getFibonacci(count));
    }

    static BigInteger getFibonacci(BigInteger count) {
        if (count.equals(BigInteger.ONE) || count.equals(BigInteger.valueOf(2))) return BigInteger.ONE;
        return getFibonacci(count.subtract(BigInteger.ONE)).add(getFibonacci(count.subtract(BigInteger.valueOf(2))));
    }
}