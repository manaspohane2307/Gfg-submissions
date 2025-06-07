// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        int n = bt.length;
        Arrays.sort(bt);
        int time=0,wt=0;
        for(int i=0;i<n;i++){
            wt += time;
            time += bt[i];
        }
        return wt/n;
    }
}
