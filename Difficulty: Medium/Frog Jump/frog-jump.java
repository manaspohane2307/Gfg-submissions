// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return tabulation(n-1,dp,height);
        
    }
    
    static int tabulation(int index, int[] dp, int[] heights){
        dp[0] = 0;//base case
        int n = heights.length;
        for(int i=1;i<n;i++){
            int jumpone = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int jumptwo = Integer.MAX_VALUE;
            if(i>1){
                jumptwo = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(jumpone,jumptwo);
        }
        return dp[n-1];
        
    }
}