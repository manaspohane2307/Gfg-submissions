// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int n = arr.length;
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(countPartitions(arr, mid) <= k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        } 
        return low;
    }
    
    int countPartitions(int[] arr, int maxsum){
        int n = arr.length;
        int partitions=1;
        long subarraysum = 0;
        for(int i=0;i<n;i++){
            if(subarraysum + arr[i] <= maxsum){
                subarraysum += arr[i];
            }
            else{
                partitions++;
                subarraysum = arr[i];
            }
        }
        return partitions; 
    }
}
