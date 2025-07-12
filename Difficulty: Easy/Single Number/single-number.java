// User function Template for Java

class Solution {
    int getSingle(int arr[]) {
        // code here
        int n = arr.length;
        int xor=0;
        for(int num : arr){
            xor = xor ^ num;
        }
        return xor;
    }
}