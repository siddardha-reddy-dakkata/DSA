#include <iostream>
#include <vector>
using namespace std;

void buildTree(vector<long long>& arr, vector<long long>& segmentTree, long long index, long long start, long long end) {
    if (start == end) {
        segmentTree[index] = arr[start];
        return;
    }
    
    long long mid = (start + end) >> 1;
    buildTree(arr, segmentTree, 2 * index, start, mid);
    buildTree(arr, segmentTree, 2 * index + 1, mid + 1, end);
    
    segmentTree[index] = segmentTree[2 * index] + segmentTree[2 * index + 1];
}

long long search(long long qStart, long long qEnd, long long s, long long e, vector<long long>& segmentTree, long long index) {
    if (qStart > e || qEnd < s) {
        return 0;
    } else if (s >= qStart && e <= qEnd) {
        return segmentTree[index];
    }
    
    long long mid = (s + e) >> 1;
    long long left = search(qStart, qEnd, s, mid, segmentTree, 2 * index);
    long long right = search(qStart, qEnd, mid + 1, e, segmentTree, 2 * index + 1);
    
    return left + right;
}

int main() {
    long long n, q;
    cin >> n >> q;
    
    vector<long long> arr(n);
    for (long long i = 0; i < n; i++) {
        cin >> arr[i];
    }
    
    vector<long long> segmentTree(4 * n + 1);
    buildTree(arr, segmentTree, 1, 0, n - 1);
    
    while (q-- > 0) {
        long long start, end;
        cin >> start >> end;
        
        long long res = search(start - 1, end - 1, 0, n - 1, segmentTree, 1);
        cout << res << endl;
    }
    
    return 0;
}
