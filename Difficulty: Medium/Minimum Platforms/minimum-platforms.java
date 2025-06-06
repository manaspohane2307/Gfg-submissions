// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        int max_count=1;
        int count=1;
        while(i<n && j<n){
            
            if(arr[i] <= dep[j]){
                count++;
                i++;
            }
            else if(arr[i] > dep[j]){
                count--;
                j++;
            }
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}
