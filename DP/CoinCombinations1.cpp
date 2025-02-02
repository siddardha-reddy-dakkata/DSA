#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<long long> dp(k + 1, 0);
    int mod = 1000000007;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (arr[i] <= k) dp[arr[i]]++;
    }

    for (int i = 1; i <= k; i++) {
        for (int j = 0; j < n; j++) {
            if (i - arr[j] >= 0) {
                dp[i] = (dp[i] + dp[i - arr[j]]) % mod;
            }
        }
    }

    cout << dp[k] << endl;
    return 0;
}
