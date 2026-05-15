import java.util.*;
import java.io.*;

public class Main {
    // 边结构体
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w; // 按成本升序排序
        }
    }

    static int[] parent;

    // 并查集查找：路径压缩
    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        Edge[] edges = new Edge[M];
        
        for (int i = 0; i < M; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        // 1. Kruskal 核心：排序
        Arrays.sort(edges);

        // 2. 并查集初始化
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        long minCost = 0;
        int count = 0;

        // 3. 遍历并合并
        for (Edge edge : edges) {
            int rootU = find(edge.u);
            int rootV = find(edge.v);
            
            if (rootU != rootV) {
                parent[rootU] = rootV;
                minCost += edge.w;
                count++;
                if (count == N - 1) break; // 已经连通所有村庄
            }
        }
        System.out.println(minCost);
    }
}