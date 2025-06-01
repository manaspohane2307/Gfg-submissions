
class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // Your code goes here.
        int n = greed.length;
        int m = cookie.length;
        Arrays.sort(greed);
        Arrays.sort(cookie);
        int l=0;//size
        int r=0;//greed
        while(l<m && r<n){
            if(greed[r]<=cookie[l]){//greed satisfied
                r++;//move to next child
            }
            l++;//check next size
        }
        return r;
    }
}