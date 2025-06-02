// User function Template for Java

class Solution {
    public static long divide(long dividend, long divisor) {
        // code here
        if (dividend == divisor) {
        return 1;
    }

    // Determine the sign of the result
    boolean sign = (dividend < 0) == (divisor < 0);

    // Work with positive values
    long n = Math.abs(dividend);
    long d = Math.abs(divisor);
    long ans = 0;

    while (n >= d) {
        int count = 0;
        while (n >= (d << (count + 1))) {
            count++;
        }
        ans += 1L << count;
        n -= d << count;
    }

    // Result is never out of long bounds, but if needed, add custom clamp here

    return sign ? ans : -ans;
    }
}