public class CircularDoublyLinkedList {
    
    // Node class for doubly linked list
    private class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head;
    private int size;
    
    public CircularDoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    
    // Insert at the ending
    public void insertAtEnding(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
        }
        size++;
    }
    
    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        if (position == size) {
            insertAtEnding(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }
    
    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }
    
    // Delete from ending
    public void deleteFromEnding() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }
        size--;
    }
    
    // Delete from a specific position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }
        
        if (position == 0) {
            deleteFromBeginning();
            return;
        }
        
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }
    
    // Search for an element
    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        
        return false;
    }
    
    // Display list forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("Forward: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    // Display list backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node tail = head.prev;
        Node current = tail;
        System.out.print("Backward: ");
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }
    
    // Get size of the list
    public int getSize() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        System.out.println("=== Circular Doubly Linked List Demo ===\n");
        
        // Insert elements
        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnding(20);
        list.insertAtEnding(25);
        list.insertAtPosition(15, 2);
        
        System.out.println("After insertions:");
        list.displayForward();
        list.displayBackward();
        System.out.println("Size: " + list.getSize());
        
        // Search
        System.out.println("\nSearching for 15: " + list.search(15));
        System.out.println("Searching for 100: " + list.search(100));
        
        // Delete operations
        System.out.println("\nDeleting from beginning:");
        list.deleteFromBeginning();
        list.displayForward();
        
        System.out.println("\nDeleting from ending:");
        list.deleteFromEnding();
        list.displayForward();
        
        System.out.println("\nDeleting from position 1:");
        list.deleteFromPosition(1);
        list.displayForward();
        
        System.out.println("\nFinal size: " + list.getSize());
    }
}