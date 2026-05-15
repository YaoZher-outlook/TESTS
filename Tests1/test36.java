package Tests;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class test36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long[] sum = new long[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                sum[n - i] = sum[n - i - 1] + a[i];
            }

            int[] maxs = new int[n];
            maxs[0] = a[0];
            for (int i = 1; i < n; i++) {
                maxs[i] = Math.max(maxs[i - 1], a[i]);
            }

            long[] answer = new long[n + 1];
            for (int k = 1; k <= n; k++) {
                long cand1 = sum[k];
                long cand2 = (k == 1 ? 0 : sum[k - 1]) + maxs[n - k];
                answer[k] = Math.max(cand1, cand2);
            }

            for (int k = 1; k <= n; k++) {
                pw.print(answer[k]);
                if (k < n) pw.print(" ");
            }
            pw.println();
        }
        pw.close();
    }
}