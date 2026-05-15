import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 使用快速 IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tStr = br.readLine();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr.trim());

        while (t-- > 0) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int n1 = Integer.parseInt(firstLine[1]);
            int n2 = Integer.parseInt(firstLine[2]);

            // 存储第一个状态的所有社区指纹
            HashSet<String> communitySignatures = new HashSet<>(n1);

            // 处理 n1 个原始社区
            for (int i = 0; i < n1; i++) {
                communitySignatures.add(getSignature(br.readLine()));
            }

            int count = 0;
            // 处理 n2 个演变后的社区
            for (int i = 0; i < n2; i++) {
                if (communitySignatures.contains(getSignature(br.readLine()))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * 生成社区的唯一字符串指纹
     * 1. 将一行中的节点 ID 提取出来
     * 2. 排序（确保顺序无关性）
     * 3. 拼接成字符串作为 HashMap 的 Key
     */
    private static String getSignature(String line) {
        if (line == null || line.isEmpty()) return "";
        StringTokenizer st = new StringTokenizer(line);
        List<Integer> nodes = new ArrayList<>();
        while (st.hasMoreTokens()) {
            nodes.add(Integer.parseInt(st.nextToken()));
        }
        // 关键：排序保证 {1, 4, 5} 和 {5, 1, 4} 生成相同的指纹
        Collections.sort(nodes);
        return nodes.toString(); 
    }
}