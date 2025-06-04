/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int diameter = 0;//passed as global variable

    int height(Node root){
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter,lh+rh);//update diameter
        return 1+Math.max(lh,rh);
    }
    int diameter(Node root) {
        // Your code here
        height(root);
        return diameter;
    }
}