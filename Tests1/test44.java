package Tests;

import java.util.Scanner;

public class test44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        if(s == "gg" || s == "ag" || s == "ug"){System.out.println(0);return;}
        if(s == "gu" || s == "ga"){System.out.println(2);return;}
        
        int guCount = 0;
        int gCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'g') {
                gCount++;
            } else if (s.charAt(i) == 'u') {
                if (gCount > 0) {
                    guCount++;
                    gCount--;
                }
            }
        }

        int gaCount = 0;
        int aCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                aCount++;
            } else if (s.charAt(i) == 'g') {
                if (aCount > 0) {
                    gaCount++;
                    aCount--;
                }
            }else if (s.charAt(i) == 'u') {
                break;
            }
        }

        int maxLen = 2 * (guCount + gaCount);
        
        System.out.println(maxLen);
    }
}