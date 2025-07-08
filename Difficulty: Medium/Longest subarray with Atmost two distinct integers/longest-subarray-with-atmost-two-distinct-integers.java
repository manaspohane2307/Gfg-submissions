class Solution {
    public int totalElements(int[] arr) {
        // code here
        int left=0, right=0, maxlen=0, k=2;
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right<n){
            mpp.put(arr[right], mpp.getOrDefault(arr[right],0)+1);
            if(mpp.size() > k){
                mpp.put(arr[left], mpp.get(arr[left])-1);
                if(mpp.get(arr[left])==0){
                    mpp.remove(arr[left]);
                }
                left++;
            }
            if(mpp.size() <= k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}