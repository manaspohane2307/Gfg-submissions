// User function Template for Java

class Solution {
    static int minCandy(int arr[]) {
        // code here
        int n = arr.length;
        int i=1;
        int sum=1;
        while(i<n){
            //same ratings
            while(i<n && arr[i]==arr[i-1]){
                sum += 1;
                i++;
                continue;
            }
            //increasing slope
            int peak=1;
            while(i<n && arr[i] > arr[i-1]){
                peak += 1;//peak increased first then added
                sum += peak;
                i++;
            }
            //decreasing slope
            int down=1;
            while(i<n && arr[i] < arr[i-1]){
                sum += down;//down added first then increased
                down += 1;
                i++;
            }
            if(down > peak){
                sum += (down-peak);
            }
        }
        return sum;
    }
}
