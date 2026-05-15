package Tests;
import java.util.Arrays;
import java.util.Scanner;
public class test12 {
    public static void main(String[] args) {
        int[] scores = new int[6];
        Scanner sc = new Scanner(System.in);   
        System.out.println("请输入6个0-100的分数:");
        for (int i = 0; i < 6; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] < 0 || scores[i] >= 100) {
                System.out.println("分数必须在0-100之间！");
                i--;
            }
        }
        sc.close();
        Arrays.sort(scores);
        int sum = 0;
        for (int i = 1; i < 5; i++) {sum += scores[i];}
        double average = sum / 4.0;
        System.out.printf("平均分: %.2f", average);
    }
}