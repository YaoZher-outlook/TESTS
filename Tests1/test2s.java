package Tests;
import java.util.Random;
public class test2s {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++){
            Random r = new Random();
            arr[i] = r.nextInt(100); 
        }
        for (int u = 0; u < arr.length; u ++) {
            System.out.println(arr[u]);
        }
        int num = 0;
        Random d = new Random(); 
        for (int j = 0; j < arr.length; j++) {
            int randomIndex = d.nextInt(arr.length);
            num = arr[j];
            arr[j] = arr[randomIndex];
            arr[randomIndex] = num;
        }
        for (int y = 0; y < arr.length; y ++) {
            System.out.println(arr[y]);
        }
    }
}
