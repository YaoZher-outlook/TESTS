//加密

package Tests;
import java.util.Scanner;
public class test13 {
    public static void  main(String[] args) {
        System.out.println("请输入密码");
        Scanner sc = new Scanner(System.in);
        int[] InputCode = new int[4];
        int Num = 0;
        for (int i = 0; i < InputCode.length; i++) {
            Num = sc.nextInt();
            if (Num >= 0 && Num < 10) {InputCode[i] = Num;}
            else {
                System.out.println("输入数字属于0~10");
                 i--;
            }
        
        }
        sc.close();
        int[] FinalCode = new int[InputCode.length];
        FinalCode = Coding(InputCode);
        System.out.print("加密后为：");
        for (int u = 0; u < FinalCode.length; u++) {
            System.out.print(FinalCode[u]);
        } 
    }
    public static int[] Coding(int[] InputCode) {
        int EachNum = 0;
        for (int i = 0; i < InputCode.length; i++) {
            EachNum = InputCode[i];
            EachNum = (EachNum + 5) % 10;
            InputCode[i] = EachNum;
        }
        int[] Outputcode =  new int[InputCode.length]; 
      for (int u = 0; u < Outputcode.length; u++) {
        Outputcode[u] = InputCode[Outputcode.length - 1 - u];
      }
        return Outputcode;
    }

}
