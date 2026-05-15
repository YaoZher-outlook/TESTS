package Tests;

import java.util.Scanner;

public class test19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String str = sc.next();

        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {smallCount++;}
            if (c >= 'A' && c <= 'Z') {bigCount++;}
            if (c >= '0' && c <= '9') {numberCount++;}
        }
        System.out.println("大写字母个数为：" + bigCount);
        System.out.println("小写字母个数为：" + smallCount);
        System.out.println("数字个数为：" + numberCount);
        sc.close();
    }
}
