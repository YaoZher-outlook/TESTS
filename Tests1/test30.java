package Tests;

import java.util.Scanner;

public class test30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer ^= sc.nextInt();
        }
        System.out.println(answer);
        sc.close();
    }
}
