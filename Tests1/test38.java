package Tests;

import java.util.Scanner;

public class test38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();
        
        int[] gu = new int[n + 1];
        int gCount = 0;
        for (int i = 0; i < n; i++) {
            gu[i + 1] = gu[i];
            if (s.charAt(i) == 'g') {
                gCount++;
            } else if (s.charAt(i) == 'u') {
                if (gCount > 0) {
                    gu[i + 1]++;
                    gCount--;
                }
            }
        }
        
        int[] ga = new int[n + 1];
        gCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            ga[i] = ga[i + 1];
            if (s.charAt(i) == 'g') {gCount++;}
            else if (s.charAt(i) == 'a') {
                if (gCount > 0) {
                    ga[i]++;
                    gCount--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, 2 * (gu[i] + ga[i]));
        }
        System.out.println(answer);
    }
}