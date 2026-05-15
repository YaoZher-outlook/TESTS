package Tests;

import java.util.Scanner;

public class test34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int k = 1;
            if(a[n-k-1] > a[n - k])
            
            
            k++;
        }

        sc.close();
    }

}