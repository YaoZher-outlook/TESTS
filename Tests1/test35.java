package Tests;

import java.util.Scanner;

public class test35{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        for (int v = 0; v < t; v++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            sc.close();
        
            long[] Sum = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                Sum[n - i] = Sum[n - i - 1] + a[i];
            }
        
            int[] maxs = new int[n];
            maxs[0] = a[0];
            for (int i = 1; i < n; i++) {
                maxs[i] = Math.max(maxs[i - 1], a[i]);
            }
        
            long[] answer = new long[n + 1];
            for (int k = 1; k <= n; k++) {
                if (k == 1) {
                    answer[k] = maxs[n - 1];
                } else {
                    long cand1 = Sum[k];
                    long cand2 = Sum[k - 1] + maxs[n - k];
                    answer[k] = Math.max(cand1, cand2);
                }
                System.out.println(answer[k]);
            }
        }
    }
}