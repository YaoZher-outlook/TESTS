#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
#include <unordered_set>

using namespace std;

// 使用哈希函数将一个社区（节点向量）转化为唯一的指纹
size_t hash_community(vector<int>& nodes) {
    sort(nodes.begin(), nodes.end()); // 确保顺序无关
    size_t seed = nodes.size();
    for(int x : nodes) {
        // 参考 boost 的 hash_combine
        seed ^= x + 0x9e3779b9 + (seed << 6) + (seed >> 2);
    }
    return seed;
}

void solve() {
    int t;
    if (!(cin >> t)) return;
    while (t--) {
        int N, n1, n2;
        cin >> N >> n1 >> n2;
        string line;
        getline(cin, line); // 跳过前一行的换行符

        unordered_set<size_t> seen_hashes;

        // 处理改变前的 n1 个社区
        for (int i = 0; i < n1; ++i) {
            getline(cin, line);
            stringstream ss(line);
            int id;
            vector<int> nodes;
            while (ss >> id) nodes.push_back(id);
            seen_hashes.insert(hash_community(nodes));
        }

        int count = 0;
        // 处理改变后的 n2 个社区
        for (int i = 0; i < n2; ++i) {
            getline(cin, line);
            stringstream ss(line);
            int id;
            vector<int> nodes;
            while (ss >> id) nodes.push_back(id);
            if (seen_hashes.count(hash_community(nodes))) {
                count++;
            }
        }
        cout << count << endl;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); // 极致的输入加速
    solve();
    return 0;
}