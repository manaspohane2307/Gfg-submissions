class Solution {
    public static int countBitsFlip(int a, int b) {
        // code here
        int count=0;
        int ans = a^b;
        for(int i=0;i<32;i++){
            if((ans & (1<<i)) != 0){
                count++;
            }
        }
        return count;
    }
}
