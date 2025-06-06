// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int count=1;//included first interval
        int lastend = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= lastend){//>= allowed only in this problem
                count++;
                lastend = intervals[i][1];
            }
        }
        return n-count;
    }
}
