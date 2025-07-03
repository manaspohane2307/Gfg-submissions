class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n = arr.length;
        //apply binary search on missing array values
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (low+k);
    }
}