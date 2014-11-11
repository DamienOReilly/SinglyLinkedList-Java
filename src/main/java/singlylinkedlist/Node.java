package singlylinkedlist;

/**
 * Node in a linked list. Contains a next node's data, and a link to the next next node.
 *
 * @author Damien O'Reilly
 */
public class Node<T> {

    private Node nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
        nextNode = null;
    }

    public Node(Node nextNode, T data) {
        this.nextNode = nextNode;
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

}