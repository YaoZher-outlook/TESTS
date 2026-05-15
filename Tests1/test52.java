package Tests;

import java.util.Scanner;
import java.util.regex.Pattern;
public class test52{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        
        String regex = "^[a-zA-Z0-9_]{1,16}@([a-zA-Z0-9_]{1,16}\\.)*[a-zA-Z0-9_]{1,16}(/[a-zA-Z0-9_]{1,16})?$";
        
        if (Pattern.matches(regex, str))System.out.println("YES");
        else System.out.println("NO");
    }
}