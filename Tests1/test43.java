package Tests;

import java.util.Scanner;

public class test43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();
        
        int guCount = 0;
        int gaCount = 0;
        
        int gAvailable = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'g') {
                gAvailable++;
            } else if (s.charAt(i) == 'u') {
                if (gAvailable > 0) {
                    guCount++;
                    gAvailable--;
                }
            }
        }
        
        int aAvailable = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                aAvailable++;
            } else if (s.charAt(i) == 'g') {
                if (aAvailable > 0) {
                    gaCount++;
                    aAvailable--;
                }
            }else if (s.charAt(i) == 'u') {
            break;
            }
        }
        int maxLen = 2 * gaCount + 2 * guCount; 
        
        System.out.println(maxLen);
    }
}