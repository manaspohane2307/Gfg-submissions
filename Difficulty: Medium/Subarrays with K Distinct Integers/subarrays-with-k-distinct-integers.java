// User function Template for Java

class Solution {
    static int exactlyK(int arr[], int k) {
        // code here
        //Exactly K = AtMost(K) - AtMost(K-1)
        int ans = func(arr, k) - func(arr,k-1);
        return ans;
        
    }
    static public int func(int[] arr, int k) {
        int n = arr.length;
        int left=0, right=0, count=0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right < n){
            mpp.put(arr[right],mpp.getOrDefault(arr[right],0)+1);
            while(mpp.size()>k){
                mpp.put(arr[left],mpp.get(arr[left])-1);
                if(mpp.get(arr[left])==0){
                    mpp.remove(arr[left]);
                }
                left++;
            }
            count = count + (right-left+1);
            right++;
        }
        return count;
    }
}
