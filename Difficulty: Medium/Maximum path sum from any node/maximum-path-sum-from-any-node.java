/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here
        int[] maxsum = new int[1];
        maxsum[0] = Integer.MIN_VALUE;
        maxSumDown(node, maxsum);
        return maxsum[0];
    }
    static int maxSumDown(Node root, int[] maxsum){
        if(root==null){
            return 0;
        }
        int leftsum = Math.max(0,maxSumDown(root.left,maxsum));
        int rightsum = Math.max(0,maxSumDown(root.right,maxsum));
        maxsum[0] = Math.max(maxsum[0], leftsum + rightsum + root.data);
        return Math.max(leftsum,rightsum)+root.data;
    }
}