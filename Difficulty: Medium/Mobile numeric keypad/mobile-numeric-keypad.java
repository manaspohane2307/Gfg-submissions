class Solution {
    public int getCount(int n) {
        // code here
        //construct matrix(4*3) to convert to dp
        //in matrix store 1 on allowed blocks - except * and #
        //store -1 on * and #
        
        int dialpad[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans += helper(i,j,dialpad,n,new HashMap<>());
            }
        }
        return ans;
    }
    
    int helper(int i, int j, int dial[][], int n,Map<String,Integer> mpp){
        if(i<0 || j<0 || i==4 || j==3 || dial[i][j]==-1){
            return 0;
        }
        String key = i + " " + j + " " + n;
        if(mpp.containsKey(key)){
            return mpp.get(key);
        }
        int curr=0;
        if(n==1){
            return 1;
        }
        curr += helper(i,j,dial,n-1,mpp);
        curr += helper(i-1,j,dial,n-1,mpp);
        curr += helper(i+1,j,dial,n-1,mpp);
        curr += helper(i,j+1,dial,n-1,mpp);
        curr += helper(i,j-1,dial,n-1,mpp);
        mpp.put(key,curr);
        return curr;
    }
}