package node;

public class LinkedList {
    private Node head;
    private Node tail;

    public Node findNode(int value) {
        Node node = head;
        while (node.nextNode != null) {
            node = node.nextNode;
            if(node.value == value){
                return node;
            }
        }

        return null;
    }

    class Node {
        private int value;
        private Node nextNode;
        private Node previousNode;
    }
}
