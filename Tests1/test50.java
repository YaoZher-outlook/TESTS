package Tests;
import java.util.Scanner;

public class test50{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++){
            long num = sc.nextInt();
        if(is(num)){num += 2;}
        else{
            System.out.println("NO");
            break;
            }
        if(is(num)){num += 2;}
        else{
            System.out.println("NO");
            break;
            }
        if(is(num)){System.out.println("YES");}
        else{
            System.out.println("NO");
            break;
            }
        }
    }
    static boolean is(long num){
        for(int i = 2; i * i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}