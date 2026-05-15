package Tests;
import java.util.Random;
import java.util.Scanner;
public class test11 {
    public static void main(String[] args) {
        String code = code();
        System.out.println(code);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        boolean result = comp(input,code);
        if (result == true) System.out.println("验证通过");
        else System.out.println("验证错误");
    }
    public static String code() {
        String code = "";
        char[] codeB = new char[52];
        for (int i = 0; i <52; i++){
            if (i < 26) codeB[i] = (char)('a' + i);
            else codeB[i] = (char)('A' + i - 26);
        }
        Random r = new Random();
        for (int u = 0; u < 4; u++) {
            int randomIndex = r.nextInt(codeB.length); 
            code = code + codeB[randomIndex];
        }
        code = code + r.nextInt(10);
        return code;
    }
    public static boolean comp(String input,String code) {
        boolean result = false;
        if (input.equals(code)) {result = true;}
        return result;
    }
}
