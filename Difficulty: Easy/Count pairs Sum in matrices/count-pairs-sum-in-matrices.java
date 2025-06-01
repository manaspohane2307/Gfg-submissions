class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int pairs=0;
        int n = mat1.length;
        Set<Integer> st = new HashSet<>();
        //put elements of 2nd matrix in set
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                st.add(mat2[i][j]);
            }
        }
        //traverse over mat1 elements
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int elem = mat1[i][j];
                int tofind = x-elem;
                if(st.contains(tofind)){
                    pairs++;
                }
            }
        }
        return pairs;
    }
}