// User function Template for Java

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = deno.length;
        for(int i=n-1;i>=0;i--){
            while(N >= deno[i]){
                N -= deno[i];
                ans.add(deno[i]);
            }
        }
        return ans;
    }
}