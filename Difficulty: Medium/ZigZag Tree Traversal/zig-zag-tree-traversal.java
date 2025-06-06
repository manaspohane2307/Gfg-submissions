/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG {
    // Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<Node> q = new LinkedList<>();
    boolean leftToRight = true;

    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();
        ArrayList<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Node temp = q.poll();
            level.add(temp.data);

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

        if (!leftToRight) {
            Collections.reverse(level);
        }

        ans.addAll(level);
        leftToRight = !leftToRight;
    }

    return ans;
    }
}