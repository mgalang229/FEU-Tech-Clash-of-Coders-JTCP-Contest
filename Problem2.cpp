#include <bits/stdc++.h>
 
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int l;
    cin >> l;
    cin.ignore();
    string s;
    getline(cin, s);
    string ans = "";
    auto Vowel = [](char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
  };
    for (int i = 0; i < (int) s.size(); i++) {
        if (Vowel(s[i])) {
            if (i == 0 || !Vowel(s[i - 1])) {
                ans += "ub";
            }
        }
        ans += s[i];
    }
    cout << ans << '\n';
    return 0;
}
