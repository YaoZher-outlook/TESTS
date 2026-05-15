package Tests;

import java.util.Scanner;

public class test20 {
    public static void main(String[] args) {
        System.out.println("输入金额：");
        Scanner sc = new Scanner(System.in);
        int money = 0;
        while (true) {
            money = sc.nextInt();
            if (money >= 0 && money <= 50000000){
                break;
            }else{
                System.out.println("金额无效！");
            }
        }
        String moneyStr = "";
        while (true) {
            int ge = money % 10;
            String capitalNumber = getCaptitalNumber(ge);
            moneyStr = capitalNumber + moneyStr;
            money = money / 10;
            if (money == 0) {break;}
        }
        System.out.println(moneyStr);
        int count = 7 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }
        String capitalizedNumbers = outputCapitalNumers(moneyStr);
        System.out.println(capitalizedNumbers);
        sc.close();
    }
    public static String getCaptitalNumber(int number) {
        String[] arr1 = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String capitalNumber = arr1[number];
        return capitalNumber;
    }

    public static String outputCapitalNumers(String  moneyStr)  {
        String capitalNumbers =  "";
        String[] arr2 = {"仟", "佰", "拾", "万", "仟", "佰", "拾", "元"};
        String[] arr3 = new String[moneyStr.length()];
        for (int u = 0; u < arr3.length; u++) {
            char c = moneyStr.charAt(u);
            capitalNumbers =  capitalNumbers + c + arr2[u];
        }
        return capitalNumbers;
    }

}
