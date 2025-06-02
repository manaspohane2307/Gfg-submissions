// User function Template for Java

class Solution {
    // k is the maximum number of zeros allowed to flip
    public int maxOnes(int arr[], int k) {
        // code here
        int maxlen=0;
        int n = arr.length;
        int l=0,r=0;
        int zeroes=0;
        while(r<n){
            if(arr[r]==0){
                zeroes++;
            }
            while(zeroes > k){
                if(arr[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes <= k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}