package Tests;

import java.math.BigInteger;

public class test33 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("1145141919810");
        String bi = num.toString(2);
        int Count0 = 0, Count1 = 0;
        for (char c : bi.toCharArray()) {
            if (c == '0') Count0++;
            else Count1++;
        }
        int ans = Math.min(Count0, 1 + Count1);
        System.out.println(ans);
    }
}