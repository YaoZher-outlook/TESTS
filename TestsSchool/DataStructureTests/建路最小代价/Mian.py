import sys

def solve():
    # 读取村庄数 N 和潜在路径数 M
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    N = int(input_data[0])
    M = int(input_data[1])
    
    edges = []
    idx = 2
    for _ in range(M):
        u = int(input_data[idx])
        v = int(input_data[idx+1])
        w = int(input_data[idx+2])
        edges.append((u, v, w))
        idx += 3

    # 1. 按照造价从小到大排序
    edges.sort(key=lambda x: x[2])

    # 2. 初始化并查集
    parent = list(range(N + 1))

    def find(i):
        if parent[i] == i:
            return i
        # 路径压缩优化
        parent[i] = find(parent[i])
        return parent[i]

    def union(root1, root2):
        if root1 != root2:
            parent[root1] = root2
            return True
        return False

    min_cost = 0
    edges_count = 0

    # 3. 贪心选择边
    for u, v, w in edges:
        root_u = find(u)
        root_v = find(v)
        
        # 如果不在同一个集合，说明不构成环
        if root_u != root_v:
            union(root_u, root_v)
            min_cost += w
            edges_count += 1
            # 提前结束优化：N个点只需要N-1条边
            if edges_count == N - 1:
                break

    print(min_cost)

if __name__ == "__main__":
    solve()