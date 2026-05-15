package Tests;

import java.util.Scanner;
import java.util.StringJoiner;

public class test22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串: ");
        String input = scanner.nextLine();
        
        StringJoiner joiner = new StringJoiner("---", "[", "]");
        
        for (char c : input.toCharArray()) {
            joiner.add(String.valueOf(c));
        }
        
        System.out.println(joiner.toString());
        
        scanner.close();
    }
}