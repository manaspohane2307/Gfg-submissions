// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev = null;
        Node temp = head;

        while(temp!=null){
            Node front = temp.next;//store front
            temp.next = prev;//reversal step
            prev = temp;//move prev forward
            temp = front;//move temp forward
        }
        return prev;
    }
}