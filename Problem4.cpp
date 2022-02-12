#include <bits/stdc++.h>
 
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int d, m;
    cin >> d >> m;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < i + m; j++) {
            sum += a[j];
        }
        if (sum == d) {
            cnt++;
        }
    }
    cout << cnt << '\n';
    return 0;
}
