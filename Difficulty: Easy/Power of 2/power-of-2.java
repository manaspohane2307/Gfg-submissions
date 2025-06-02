// User function Template for Java

class Solution {
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(int n) {
        // code here
        if((n & (n-1))==0){
            return true;
        }
        return false;
        
    }
}