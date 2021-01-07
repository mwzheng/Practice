package Data_Structs;

/**
 * SinglyLinked list that holds a string as data
 **/
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    /**
     * Node for singly linked list
     **/
    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String toString() {
            return this.data;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a single node to the head of the singly linked list.
     * Returns true if successful, false otherwise.
     **/
    public boolean insertHead(Node newNode) {
        if (newNode == null)
            return false;

        newNode.next = head;
        head = newNode;
        size++;

        if (size == 1) // Tail is the head when length of LL is 1
            tail = newNode;

        return true;
    }

    /**
     * Adds a node to the end of the Singly Linked List.
     * Returns true if successful, false otherwise.
     **/
    public boolean insertTail(Node newNode) {
        if (newNode == null)
            return false;

        if (isEmpty()) { // List is empty so newNode is head & tail
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
        return true;
    }

    /**
     * Insert the given node at the given index.
     * Returns true if successful, false otherwise.
     **/
    public boolean insertIndex(Node newNode, int index) {
        if (newNode == null || index < 0)
            return false;

        if (index > size) { // Insert at index greater than list so add to end
            insertTail(newNode);
        } else if (index == 0) { // Insert at head
            insertHead(newNode);
        } else {
            int currIndex = 0;
            Node prev = null;
            Node curr = head;

            while (currIndex != index) {
                prev = curr;
                curr = curr.next;
                currIndex++;
            }

            prev.next = newNode;
            newNode.next = curr;
            size++;
        }

        return true;
    }

    /**
     * Inserts a newNode in order (starting at head).
     **/
    public void insertInOrder(Node newNode) {
        if (newNode == null)
            return;

        Node prevNode = null;
        Node currNode = head;

        if (isEmpty() || newNode.getData().compareTo(currNode.getData()) < 0) {
            insertHead(newNode);
        } else {
            while (currNode != null && newNode.getData().compareTo(currNode.getData()) > 0) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            if (currNode == null) {
                insertTail(newNode);
            } else if (prevNode != null) {
                prevNode.next = newNode;
                newNode.next = currNode;
                size++;
            }
        }
    }

    /**
     * Removes current head of the Singly Linked List.
     * Returns data form node removed if successful, otherwise returns empty string.
     **/
    public String removeHead() {
        if (head == null)
            return "";

        String data = head.getData();
        head = head.next;
        size--;
        return data;
    }

    /**
     * Removes the tail of the Singly Linked List.
     * Returns the data of the node if successful, otherwise returns empty string
     **/
    public String removeTail() {
        if (tail == null)
            return "";

        String data;

        if (size == 1) { // If you're removing head
            data = head.getData();
            head = null;
            tail = null;
        } else {
            Node prevNode = null;
            Node currNode = head;

            while (currNode.next != null) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            data = currNode.getData();

            // Set new tail & cut off the old tail
            tail = prevNode;
            tail.next = null;
        }

        size--;
        return data;
    }

    /**
     * Removes the node with the given data.
     * Returns true if successful, false otherwise.
     **/
    public boolean remove(String data) {
        if (data == null)
            return false;

        if (head.getData().equals(data)) { // Removing head
            removeHead();
        } else if (tail.getData().equals(data)) { // Remove Tail
            removeTail();
        } else { // Something in between
            Node prev = null;
            Node curr = head;
            boolean isNodeToRemove = false;

            while (!isNodeToRemove) {
                prev = curr;
                curr = curr.next;

                if (curr == null) // Data doesn't exist in list
                    return false;

                isNodeToRemove = curr.getData().equals(data);
            }

            prev.next = curr.next;
            size--;
        }

        return true;
    }

    /**
     * Removes the node at the given index.
     * Returns true if successful, false otherwise.
     **/
    public boolean removeIndex(int index) {
        if (index < 0 || index > size)
            return false;

        if (index == 0) {
            removeHead();
        } else if (index == size) {
            removeTail();
        } else {
            Node prev = null;
            Node curr = head;
            int currIndex = 0;

            while (currIndex != index) {
                prev = curr;
                curr = curr.next;
                currIndex++;
            }

            prev.next = curr.next;
            size--;
        }

        return true;
    }

    /**
     * Reverses the order of the singly linked list.
     **/
    public void reverseList() {
        SinglyLinkedList newList = new SinglyLinkedList();

        if (isEmpty())
            return;

        Node currNode = head;

        while (currNode != null) {
            newList.insertHead(new Node(currNode.getData()));
            currNode = currNode.next;
        }

        this.head = newList.head;
    }

    /**
     * Two Singly Linked List considered to be equal if they
     * contain the same data in the same order.
     **/
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SinglyLinkedList))
            return false;

        SinglyLinkedList otherList = (SinglyLinkedList) obj;
        return this.toString().equals(otherList.toString());
    }

    /**
     * Returns a string of data in singly linkedList separated by '=>'
     * Returns empty string if list is empty.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currNode = head;

        if (isEmpty())
            return "";

        while (currNode != null) {
            sb.append(currNode.toString()).append(" => ");
            currNode = currNode.next;
        }

        return sb.toString().substring(0, sb.length() - 4);
    }
}