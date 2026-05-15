package Tests;
import java.util.Random;
import java.util.Scanner;
public class test15sp {
    public static void main(String[] args) {
        String[] prizes = {"一等奖1000万","二等奖500万","三等奖300元","四等奖200元","五等奖10元","六等奖5元","很遗憾未中奖"};
        int[] winningNumbers = generateWinningNumbers();
        for (int o = 0; o < winningNumbers.length; o++) {
            System.out.print(winningNumbers[o] + " ");
        }
        int[] userNumbers = getUserNumbers();
        int redMatches = countRedMatches(userNumbers, winningNumbers);
        int blueMatch = (userNumbers[6] == winningNumbers[6]) ? 1 : 0;
        System.out.println("中奖结果: " + prizes[determinePrize(redMatches, blueMatch)]);
    }
    public static int[] getUserNumbers() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[7];
        System.out.println("输入你的号码(依次用回车确定):");
        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.print("第" + (i + 1) + "颗红球号码(1-33):");
                numbers[i] = sc.nextInt();
                if (numbers[i] > 0 && numbers[i] < 34) break;
                System.out.println("红球号码应在1~33之间");
            }
        }
        while (true) {
            System.out.print("蓝色球号码(1-16):");
            numbers[6] = sc.nextInt();
            if (numbers[6] > 0 && numbers[6] < 17) break;
            System.out.println("蓝色球号码应在1~16之间");
        }
        sc.close();
        return numbers;
    }
    public static int[] generateWinningNumbers() {
        int[] numbers = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; i++) numbers[i] = r.nextInt(33) + 1;
        numbers[6] = r.nextInt(16) + 1;
        return numbers;
    }
    public static int countRedMatches(int[] user, int[] winning) {
        int matches = 0;
        for (int i = 0; i < 6; i++) if (user[i] == winning[i]) matches++;
        return matches;
    }
    public static int determinePrize(int red, int blue) {
        if (red == 6 && blue == 1) return 0;
        if (red == 6) return 1;
        if (red == 5 && blue == 1) return 2;
        if ((red == 5) || (red == 4 && blue == 1)) return 3;
        if ((red == 4) || (red == 3 && blue == 1)) return 4;
        if ((red == 2 && blue == 1) || (red == 1 && blue == 1) || (blue == 1)) return 5;
        return 6;
    }
}