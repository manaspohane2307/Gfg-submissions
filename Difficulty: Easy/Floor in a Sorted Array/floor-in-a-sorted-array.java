class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = mid;
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }
}
