/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        leftView(root,ans,0);
        return ans;
    }
    
    static void leftView(Node root, ArrayList<Integer> ans, int level){
        if(root==null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.data);
        }
        leftView(root.left,ans,level+1);
        leftView(root.right,ans,level+1);
    }
}