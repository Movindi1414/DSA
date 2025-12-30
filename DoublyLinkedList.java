public class DoublyLinkedList {
    
    
    class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    
    public DoublyLinkedList() {
        head = null;
    }
    
    
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Inserted " + data + " at end");
    }
    
    
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Deleted " + head.data + " from beginning");
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }
    
    
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted " + head.data + " from end");
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted " + temp.data + " from end");
        temp.prev.next = null;
    }
    
    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("List (Forward): null <- ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> null");
    }
    
    
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("List (Backward): null <- ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println(" -> null");
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("=== Doubly Linked List Demo ===\n");
        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayForward();
        list.displayBackward();
        
        System.out.println();
        list.insertAtBeginning(5);
        list.displayForward();
        
        System.out.println();
        list.deleteFromBeginning();
        list.displayForward();
        
        System.out.println();
        list.deleteFromEnd();
        list.displayForward();
        list.displayBackward();
    }
}