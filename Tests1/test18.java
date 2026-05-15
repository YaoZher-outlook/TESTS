package Tests;

import java.util.Scanner;

public class test18 {
    public static void main(String[] args) {
        System.out.println("输入字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
    sc.close();
    }
}
