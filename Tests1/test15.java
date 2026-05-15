package Tests;
import java.util.Random;
import java.util.Scanner;
public class test15 {
    public static void main(String[] args) {
        String[] Prizes = {"一等奖1000万","二等奖500万","三等奖300元","四等奖200元","五等奖10元","六等奖5元","很遗憾未中奖"};
        Scanner sc = new Scanner(System.in);
        int[] InputArr = new int[7];
        int InputNumber = 0;
        System.out.println("输入你的号码(依次用回车确定):");
        for  (int i = 0; i < 6; i++) {
            System.out.print("第" + (i + 1) + "颗红球号码:");
            InputNumber = sc.nextInt();
            if (InputNumber > 0 && InputNumber < 34)  {
                InputArr[i] = InputNumber;
            }else{
                System.out.print("红球的号码应该在1~33,请重新输入");
                i--;                
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.print("蓝色球号码:");
            InputNumber = sc.nextInt();
            if (InputNumber > 0 && InputNumber < 17)  {
                InputArr[6] = InputNumber;
            }else{
                System.out.print("蓝色的号码应该在1~16,请重新输入");               
                i--;
            }
        }
        sc.close();
        int[] PrizeArr = CreateNumber();
        int CorrectRed = Red(InputArr,PrizeArr);
        int CorrectBlue = Blue(InputArr,PrizeArr);
        int Prize = Prize(CorrectRed, CorrectBlue);
        System.out.print(Prizes[Prize]);
    }
    public static int[] CreateNumber() {
        int[] NumberArr = new int[7];
        Random r = new Random();
        for (int red = 0; red < 6; red ++)
            NumberArr[red] = r.nextInt(33 + 1);
        NumberArr[6] = r.nextInt(16 + 1);
        return NumberArr;
    }
    public static int Red(int[] InputArr,int[] PrizeArr) {
        int CorrectRed = 0;
        for (int i = 0; i < InputArr.length - 1; i++) {
            if (InputArr[i] == PrizeArr[i]) CorrectRed++;
        }
        return CorrectRed;
    }
    public static int Blue(int[] InputArr,int[] PrizeArr) {
        int CorrectBlue = 0;
        if (InputArr[6] == PrizeArr[6]) CorrectBlue++;
        return CorrectBlue;
    }
    public static int Prize(int CorrectRed,int CorrectBlue) {
        int Prize = 0;
        if ((CorrectRed == 1 && CorrectBlue == 1) ||(CorrectRed == 0 &&  CorrectBlue == 1) || (CorrectRed == 2 && CorrectBlue == 1)) Prize = 5;
        else if ((CorrectRed == 3 && CorrectBlue == 1) || (CorrectRed == 4 && CorrectBlue == 0)) Prize = 4;
        else if ((CorrectRed == 4 && CorrectBlue == 1) || (CorrectRed == 5 && CorrectBlue == 0)) Prize = 3;
        else if (CorrectRed == 5 && CorrectBlue == 1) Prize = 2;
        else if (CorrectRed == 6 && CorrectBlue == 0) Prize = 1;
        else if (CorrectRed == 6 && CorrectBlue == 1) Prize = 0;
        else Prize = 6;
        return Prize;
    }
}
