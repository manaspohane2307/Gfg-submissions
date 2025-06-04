// User function Template for Java

class Solution {
    // Function to check if we can reach the last index from the 0th index.
    public boolean canReach(int[] arr) {
        // code here
        int maxIndex=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex, i+arr[i]);
        }
        return true;
    }
}