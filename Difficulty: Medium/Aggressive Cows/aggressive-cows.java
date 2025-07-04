// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int minval = Integer.MAX_VALUE, maxval = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            minval = Math.min(minval, stalls[i]);
            maxval = Math.max(maxval, stalls[i]);
        }
        int low=1, high=maxval-minval;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWePlace(stalls, mid, k)==true){
                low = mid+1;//we want maximum min value
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
    
    static boolean canWePlace(int[] stalls, int dist, int k){
        int n = stalls.length;
        int countcows=1;
        int last = stalls[0];//place first cow at first index
        for(int i=1;i<n;i++){
            if((stalls[i]-last) >= dist){//can place cow
                countcows++;
                last = stalls[i];
            }
            if(countcows==k){
                return true;
            }
        }
        return false;
    }
}