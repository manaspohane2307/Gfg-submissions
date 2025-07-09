// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        if(target<0){
            return 0;
        }
        int ans = countSubarraySum(arr,target) - countSubarraySum(arr, target-1);
        return ans;
    }
    int countSubarraySum(int[] nums, int goal){
        int n = nums.length;
        if(goal<0){
            return 0;
        }
        int left=0, right=0, count=0, sum=0;
        while(right < n){
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }
}