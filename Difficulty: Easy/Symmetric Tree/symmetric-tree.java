/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
        // Code here
        return (root==null || isSymmetrichelper(root.left, root.right));
    }
    static boolean isSymmetrichelper(Node left, Node right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.data != right.data){
            return false;
        }
        return isSymmetrichelper(left.right , right.left)
        && isSymmetrichelper(left.left,right.right);
    }
}