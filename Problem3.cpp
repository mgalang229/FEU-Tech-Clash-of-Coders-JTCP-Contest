#include <bits/stdc++.h>
 
using namespace std;

bool Happy(string num) {
    vector<int> arr;
    for (int i = 0; i < (int) num.size(); i++) {
        arr.push_back(num[i] - '0');
    }
    set<vector<int>> s;
    while (arr[0] != 1 || (int) arr.size() > 1) {
        int sum = 0;
        for (int i = 0; i < (int) arr.size(); i++) {
            sum += (arr[i] * arr[i]);
        }
        arr.clear();
        while (sum > 0) {
            arr.push_back(sum % 10);
            sum /= 10;
        }
        reverse(arr.begin(), arr.end());
        if (s.count(arr)) {
            return false;
        }
        s.insert(arr);
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m;
    cin >> m >> n;
    vector<vector<char>> a(n, vector<char>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    vector<string> ans;
    for (int i = 0; i < n; i++) {
        string num = "";
        for (int j = 0; j < m; j++) {
            num += string(1, a[i][j]);
        }
        if (!Happy(num)) {
            ans.push_back(num);
        }
    }
    if ((int) ans.size() == 0) {
        cout << "All numbers are happy" << '\n';
    } else {
         for (auto& e : ans) {
             cout << e << '\n';
         }
    }
    return 0;
}
