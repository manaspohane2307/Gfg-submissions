/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    static boolean isLeaf(Node root){//function to check leaf nodes
        return root.left==null && root.right==null;
    }

    static void addLeftBoundary(Node root, ArrayList<Integer> res){//TC=O(height of tree)
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }

    static void addRightBoundary(Node root, ArrayList<Integer> res){//TC=O(height of tree)
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

    static void addLeaves(Node root, ArrayList<Integer> res){//similar to preorder traversal = O(n)
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null){
            addLeaves(root.left, res);
        }
        if(root.right != null){
            addLeaves(root.right, res);
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(node==null){
            return res;
        }
        if(!isLeaf(node)){//add root to res
            res.add(node.data);
        }
        addLeftBoundary(node,res);
        addLeaves(node,res);
        addRightBoundary(node,res);

        return res;
    }
}