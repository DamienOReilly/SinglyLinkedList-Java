package singlylinkedlist;

/**
 * Class provides a simple implementation of a singly linked list.
 *
 * @author Damien O'Reilly
 */
public class SinglyLinkedList<T> {

    // head of the linked list.
    private Node head;
    private int size;

    /**
     * Constructor, initialize a new {@code SinglyLinkedList}
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add to the end of the linked list.
     *
     * @param data Data to insert.
     */
    public void addToEnd(T data) {
        Node newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        size++;
    }

    /**
     * Add to the start of the linked list.
     *
     * @param data Data to insert.
     */
    public void addToStart(T data) {
        head = new Node<>(head, data);
        size++;
    }

    /**
     * Removes the first element in the list
     */
    public void deleteStart() {
        if (head == null) {
            throw new IllegalStateException("Empty linked list.");
        }
        head = head.getNextNode();
        size--;
    }

    /**
     * Delete the end of the linked list.
     */
    public void deleteEnd() {
        if (head == null) {
            return;
        } else {
            Node current = head;
            Node previous = null;
            while (current.getNextNode() != null) {
                previous = current;
                current = current.getNextNode();
            }
            previous.setNextNode(null);
        }
        size--;
    }

    /**
     * Return the number of elements in the linked list.
     *
     * @return List size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a node at a given position.
     *
     * @param position Position of node.
     * @return Node.
     */
    public Node getNodeAtPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position must be 0 or greater.");
        }
        if (head == null) {
            throw new IndexOutOfBoundsException("No data in the SinglyLinkedList");
        }
        Node node = head;
        // iterate through link list until we reach position.
        for (int i = 0; i < position; i++) {
            isNodeNull(node);
            node = node.getNextNode();
        }
        isNodeNull(node);
        return node;
    }

    /**
     * Returns the first node in the list.
     *
     * @return Node.
     */
    public Node getFirstNode() {
        if (head == null) {
            throw new IllegalStateException("No data in the SinglyLinkedList");
        }
        return head;
    }

    /**
     * Returns the last node in the list.
     *
     * @return Node.
     */
    public Node getLastNode() {
        if (head == null) {
            throw new IllegalStateException("No data in the SinglyLinkedList");
        }
        Node current = head;
        while (current.getNextNode() != null) {
            current = current.getNextNode();
        }
        return current;
    }

    private void isNodeNull(Node node) {
        if (node == null) {
            throw new IndexOutOfBoundsException("Position does not exist in linked list.");
        }
    }

    /**
     * Clears linked list. Data eligible for garbage collection.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Adds a node to the linked list at a given position, moving current node forward. If list is empty,
     * node is inserted at start.
     *
     * @param position Position to add node to.
     * @param data     Data to add.
     */
    public void insert(int position, T data) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
        Node newNode = new Node<>(data);

        //list is empty?
        if (head == null) {
            addToEnd(data);
            return;
        }
        Node current = head;

        for (int i = 1; (i < position) && (current.getNextNode() != null); i++) {
            current = current.getNextNode();
        }
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
        size++;
    }


    public void delete(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position or position is larger than list size.");
        }
        if (position == 0) {
            deleteStart();
            return;
        }
        if (position + 1 == size) {
            deleteEnd();
            return;
        }
        Node current = head;
        for (int i = 1; i < position; i++) {
            if (current.getNextNode() == null) {
                throw new IndexOutOfBoundsException("Node at position " + position + " doesn't exist.");
            }
            current = current.getNextNode();
        }
        // setting link to 2 nodes ahead effectively wipes out desire node.
        current.setNextNode(current.getNextNode().getNextNode());
        size--;
    }

    /**
     * Reverse a singly linked list iteratively.
     */
    public void iterativeReverse() {

        // Empty list, do nothing.
        if (head == null) {
            return;
        }

        Node previous = null, next;
        Node current = head;

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(previous);  // set next node to previous
            previous = current;             // set previous node to current
            current = next;                 // set current node to next node
        }
        head = previous;
    }

    /**
     * Reverse a singly linked list recursively.
     */
    public void recursiveReverse() {
        head = recursiveReverse(head);
    }

    private Node recursiveReverse(Node node) {
        // check if nothing to reverse. Cannot reverse empty list.
        if (node == null) {
            return null;
        }

        if (node.getNextNode() == null) {
            return node;
        }

        Node secondNode = node.getNextNode();
        node.setNextNode(null); // will cycle and result in stack exhaustion otherwise.

        //  Reverse everything from the second element
        Node reversedNode = recursiveReverse(secondNode);

        // Now we join both the lists
        secondNode.setNextNode(node);

        return reversedNode;
    }
}