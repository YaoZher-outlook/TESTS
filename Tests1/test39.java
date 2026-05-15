package Tests;

import java.util.Scanner;

public class test39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        int[] guCount = new int[n + 1];
        int gLeft = 0;
        for (int i = 0; i < n; i++) {
            guCount[i + 1] = guCount[i];
            if (s.charAt(i) == 'g') {
                gLeft++;
            } else if (s.charAt(i) == 'u') {
                if (gLeft > 0) {
                    guCount[i + 1]++;
                    gLeft--;
                }
            }
        }
        int[] gaCount = new int[n + 1];
        int gRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            gaCount[i] = gaCount[i + 1];
            if (s.charAt(i) == 'g') {
                gRight++;
            } else if (s.charAt(i) == 'a') {
                if (gRight > 0) {
                    gaCount[i]++;
                    gRight--;
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i <= n; i++) {
            int pairs = guCount[i] + gaCount[i];
            maxLen = Math.max(maxLen, 2 * pairs);
        }

        System.out.println(maxLen);
    }
}