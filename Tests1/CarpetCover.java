package Tests;
import java.util.Scanner;

public class CarpetCover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取地毯数量
        int n = scanner.nextInt();
        
        // 存储每张地毯的信息
        int[][] carpets = new int[n][4];
        
        // 读取每张地毯的信息
        for (int i = 0; i < n; i++) {
            carpets[i][0] = scanner.nextInt(); // a
            carpets[i][1] = scanner.nextInt(); // b
            carpets[i][2] = scanner.nextInt(); // g
            carpets[i][3] = scanner.nextInt(); // k
        }
        
        // 读取查询点的坐标
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        // 从后往前遍历地毯（因为后铺的地毯在上面）
        int result = -1;
        for (int i = n - 1; i >= 0; i--) {
            int a = carpets[i][0];
            int b = carpets[i][1];
            int g = carpets[i][2];
            int k = carpets[i][3];
            
            // 检查点(x,y)是否在当前地毯范围内
            if (x >= a && x <= a + g && y >= b && y <= b + k) {
                result = i + 1; // 地毯编号从1开始
                break;
            }
        }
        
        // 输出结果
        System.out.println(result);
        
        scanner.close();
    }
}
