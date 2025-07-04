
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k>n){
            return -1;
        }
        int maxval = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            maxval = Math.max(maxval, arr[i]);
            sum += arr[i];
        }
        int low = maxval, high = sum;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(countStudents(arr, mid) > k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    
    static int countStudents(int[] arr, int pages){
        int students=1;
        int studpages=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(studpages + arr[i] <= pages){
                studpages += arr[i];
            }
            else{
                students++;
                studpages = arr[i];
            }
        }
        return students;
    }
}