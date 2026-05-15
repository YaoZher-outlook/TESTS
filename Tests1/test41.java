package Tests;

import java.util.*;

public class test41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.close();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            if (n % 2 == 1 || k > n - 1) {
                System.out.println("Impossible");
                continue;
            }
            int[][] opponent = new int[k][n + 1]; // opponent[r][p] 表示第 r 轮 p 的对手
            for (int r = 0; r < k; r++) {
                // 标准循环赛程构造，编号 0..n-1
                // 第 r 轮：固定 0 与 r+1
                // 配对：对于 i=1..n/2-1, (r+1+i, r+1-i) mod (n-1)，值 1..n-1
                int[] match = new int[n];
                Arrays.fill(match, -1);
                
                match[0] = r + 1;
                match[r + 1] = 0;
                
                for (int i = 1; i < n / 2; i++) {
                    int a = (r + 1 + i) % (n - 1);
                    int b = (r + 1 - i + (n - 1)) % (n - 1);
                    if (a == 0) a = n - 1;
                    if (b == 0) b = n - 1;
                    match[a] = b;
                    match[b] = a;
                }
                for (int p = 0; p < n; p++) {
                    opponent[r][p + 1] = match[p] + 1;
                }
            }
            for (int r = 0; r < k; r++) {
                for (int p = 1; p <= n; p++) {
                    System.out.print(opponent[r][p]);
                    if (p < n) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}