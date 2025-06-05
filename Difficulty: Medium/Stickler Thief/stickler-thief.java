class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoization(n-1,arr,dp);
    }
    static int memoization(int index, int[]arr, int[] dp){
        if(index==0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        //recursive solution
        int pick = arr[index] + memoization(index - 2, arr, dp);
        int notpick = 0 + memoization(index - 1, arr, dp);
        return dp[index] = Math.max(pick, notpick);
    }
}