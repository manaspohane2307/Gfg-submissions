/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        rightView(root, ans,0);
        return ans;
    }
    static void rightView(Node root, ArrayList<Integer> ans, int level){
        if(root==null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.data);
        }
        rightView(root.right,ans,level+1);
        rightView(root.left,ans,level+1);
    }
}