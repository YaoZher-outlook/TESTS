package Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test32 {
    public static void main(String[] args) {
        int n = 114514;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(result.get(i));
        }
        System.out.println();
    }
}