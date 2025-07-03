// User function Template for Java

class Solution {
    public static int minDaysBloom(int m, int k, int[] arr) {
        // code here
        long n = arr.length;
        if((long)m*k > n){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        int low = mini, high = maxi;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, mid, m, k)==true){
                high = mid-1;//we want minimum days
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    static boolean isPossible(int[] arr, int d, int m, int k){
        int count=0, bouq = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] <= d){
                count++;
                if(count==k){
                    bouq++;
                    count=0;
                }
            }
            else{
                count = 0;
            }
        }
        return (bouq>=m);
    }
}