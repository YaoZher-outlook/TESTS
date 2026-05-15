#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 定义公路结构体
struct Edge {
    int u, v, w;
};

// 自定义排序规则
bool compareEdges(const Edge& a, const Edge& b) {
    return a.w < b.w;
}

// 并查集数组
int parent[1001];

// 查找根节点（含路径压缩）
int findRoot(int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = findRoot(parent[i]);
}

int main() {
    int N, M;
    if (!(cin >> N >> M)) return 0;

    vector<Edge> edges(M);
    for (int i = 0; i < M; i++) {
        cin >> edges[i].u >> edges[i].v >> edges[i].w;
    }

    // 1. 按成本排序
    sort(edges.begin(), edges.end(), compareEdges);

    // 2. 初始化并查集
    for (int i = 1; i <= N; i++) parent[i] = i;

    long long minCost = 0;
    int edgesSelected = 0;

    // 3. Kruskal 算法执行
    for (int i = 0; i < M; i++) {
        int rootU = findRoot(edges[i].u);
        int rootV = findRoot(edges[i].v);

        if (rootU != rootV) {
            parent[rootU] = rootV; // 合并集合
            minCost += edges[i].w;
            edgesSelected++;
            if (edgesSelected == N - 1) break;
        }
    }

    cout << minCost << endl;

    return 0;
}