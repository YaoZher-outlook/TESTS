package Tests;
import java.util.Random;
public class test2 {
    public static void main(String[] args) { 
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            int number = r.nextInt(100) + 1;
            arr[i] = number;
    //求最大值
        }
        int max = arr[0];
        for (int t = 0; t < arr.length; t++) {
            if(arr[t] > max) {
                max = arr[t];
            }
    //求和
        }
        int sum = 0;
        for (int y = 0; y < arr.length; y++) {
            sum = sum + arr[y];
        }
    //求平均数
        int avg = sum / arr.length;
    //小于平均数的个数
        int sml = 0;
        for (int u = 0; u < arr.length; u++) {
            if (arr[u] < avg) {
                sml = sml + 1;
            }
        }
    
    
    System.out.println(arr[9]);
    System.out.println("和:" + sum);
    System.out.println("平均数:" + avg);
    System.out.println("最大值:" + max);
    System.out.println("小于平均数的个数:" + sml);
    }
    
}
