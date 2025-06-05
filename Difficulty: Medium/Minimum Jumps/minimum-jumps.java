class Solution {
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        int l=0,r=0,jumps=0;
        while(r < n-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+arr[i]);
            }
            if(farthest <= r) return -1;//handle 0 input
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}