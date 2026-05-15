package Tests;
import java.util.*;

public class test49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0){
            System.out.println(-1);
            System.exit(0);
        }
        int[][] carpets = new int[n][4];
        for(int i = 0; i < n; i++){    
            for(int u = 0; u < 4; u++){
                carpets[i][u] = sc.nextInt();
            }
        }
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int x = carpets[i][0];
            int y = carpets[i][1];
            int lenth = carpets[i][2];
            int width = carpets[i][3];

            if((x <= X && (x + lenth) >= X) && (y <= Y && (y + width >= Y))){count++;}
        }
        if(count != 0)System.out.println(count);
        else System.out.println(-1);
        sc.close();
    }
}
