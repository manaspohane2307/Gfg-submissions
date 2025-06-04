/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    public boolean isBalanced(Node root) {
        // code here
        int ans = height(root);
        return ans!= -1;
    }
    static int height(Node root) {//height function will retun height only if its balanced tree else return -1
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        if (lh == -1)
            return -1;
        int rh = height(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }
}