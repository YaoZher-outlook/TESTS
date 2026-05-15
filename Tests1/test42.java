package Tests;

import java.util.Scanner;

public class test42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();
        
        int[] guCount = new int[n + 1]; 
        int[] gaCount = new int[n + 1]; 
        
        int gAvailable = 0;
        for (int i = 0; i < n; i++) {
            guCount[i + 1] = guCount[i];
            if (s.charAt(i) == 'g') {
                gAvailable++;
            } else if (s.charAt(i) == 'u') {
                if (gAvailable > 0) {
                    guCount[i + 1]++;
                    gAvailable--;
                }
            }
        }
        
        int aAvailable = 0;
        for (int i = n - 1; i >= 0; i--) {
            gaCount[i] = gaCount[i + 1];
            if (s.charAt(i) == 'a') {
                aAvailable++;
            } else if (s.charAt(i) == 'g') {
                if (aAvailable > 0) {
                    gaCount[i]++;
                    aAvailable--;
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i <= n; i++) {
            maxLen = Math.max(maxLen,2 * gaCount[i]);
        }
        
        System.out.println(maxLen);
    }
}