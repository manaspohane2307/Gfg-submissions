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
} */

class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelWidth = queue.size();  // number of nodes at this level
            maxWidth = Math.max(maxWidth, levelWidth);

            for (int i = 0; i < levelWidth; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return maxWidth;
    }
}