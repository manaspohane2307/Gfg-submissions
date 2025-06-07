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
class Pair<K,V>{
    K first;
    V second;

    Pair(K k, V v){
        first = k;
        second = v;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer,Integer> mpp = new TreeMap<>();//will store top view nodes. Stores(node.data,vertical_line)
        //we used TreeMap as it will store in sorted order
        Queue<Pair<Node,Integer>> q = new LinkedList<>();//node and its vertical position

        q.add(new Pair<>(root, 0));

        while(!q.isEmpty()){
            //remove element from queue
            Pair<Node,Integer> temp = q.poll();
            Node node = temp.first;
            int vertical_line = temp.second;

            //if vertical position is not aldready in map then add node's data into map
            if(!mpp.containsKey(vertical_line)){
                mpp.put(vertical_line,node.data);
            }
            //we only store first occurence of a node on a vertical line as its top view
            //process left child
            if(node.left != null){
                q.add(new Pair<>(node.left, vertical_line-1));
            }
            //process right child
            if(node.right != null){
                q.add(new Pair<>(node.right, vertical_line+1));
            }
        }

        //transfer value from map to result
        for(int value : mpp.values()){
            ans.add(value);
        }
        return ans;
    }
}