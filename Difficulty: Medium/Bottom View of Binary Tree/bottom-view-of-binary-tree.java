class Pair<K,V>{
    K first;
    V second;
    Pair(K first, V second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }

        Map<Integer,Integer> mpp = new TreeMap<>();//store(vertical_line, node.data)
        Queue<Pair<Node,Integer>> q = new LinkedList<>();//store(node, vertical_line)
        q.add(new Pair<>(root, 0));//push root

        while(!q.isEmpty()){
            Pair<Node,Integer> temp = q.poll();
            Node node = temp.first;
            int vert_line = temp.second;
            mpp.put(vert_line,node.data);
            
            //check for left and right nodes
            if(node.left != null){
                q.add(new Pair<>(node.left, vert_line-1));
            }
            if(node.right != null){
                q.add(new Pair<>(node.right, vert_line+1));
            }
        }
        //put from TreeMap to ans
        for(int value : mpp.values()){
            ans.add(value);
        }
        return ans;
    }
}