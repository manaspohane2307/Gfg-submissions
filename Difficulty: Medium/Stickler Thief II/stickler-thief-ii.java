class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if(n==1){//array contains only 1 element
            return arr[0];
        }
        int[] arr1 = new int[n-1];//excluding last element
        int[] arr2 = new int[n-1];//excluding first element
        int count1=0,count2=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                arr2[count2] = arr[i];
                count2++;
            }
            if(i!=n-1){
                arr1[count1] = arr[i];
                count1++;
            }
        }
        return Math.max(spaceoptimization(arr1),spaceoptimization(arr2));
    }
    static int spaceoptimization(int[] arr){
        int n = arr.length;
        int prev=arr[0];
        int prev2=0;

        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1){
                pick += prev2;
            }
            int nonpick = prev;
            int curr = Math.max(pick,nonpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
