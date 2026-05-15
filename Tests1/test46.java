package Tests;

import java.util.*;

public class test46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        long index = sc.nextInt();
        sc.close();
        System.out.println(getAnswer(str, index));
    }
    public static char getAnswer(String str, long index){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < Math.sqrt(index); i++) {
            str = sb.append(str.charAt(str.length() - 1)).append(str).deleteCharAt(2 * str.length()).toString();
        }
        char ans = str.charAt((int)index - 1);
        return ans;
    }
}
