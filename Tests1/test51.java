package Tests;

import java.util.Scanner;

public class test51{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            if(sc.nextLong() % 8 == 0){System.out.println(1);}
            else{
                System.out.println(0);
                    System.exit(0);
            }
        };
        long[] as = new long[n];
        for(int i = 0; i < n; i++){
            as[i] = sc.nextLong();
        }
        int count = 0;
        
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < i - 1; j++){
                if((as[i] + as[j]) % 8 == 0)count++;
            }
        }
        
        System.out.println(count);
    }
}