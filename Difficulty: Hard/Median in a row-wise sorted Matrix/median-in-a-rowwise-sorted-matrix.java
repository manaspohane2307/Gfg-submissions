// User function Template for Java

class Solution {
    int median(int mat[][]) {
        // code here
        int n = mat.length, m = mat[0].length;
        int low=Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }
        int req = (n*m)/2;
        while(low <= high){
            int mid = low + (high-low)/2;
            int smallEqual = countSmallEqual(mat, n, m, mid);
            if(smallEqual <= req){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    
    static int countSmallEqual(int[][] mat, int n, int m, int mid){
        int count=0;
        for(int i=0;i<n;i++){//iterate over columns
            count += upperBound(mat[i],mid,m);
        }
        return count;
    }
    
    static int upperBound(int[] arr, int x, int m){
        int low=0, high = m-1;
        int ans=m;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > x){
                ans = mid;
                high = mid-1;//check more smaller
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}