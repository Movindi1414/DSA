public class SinglyLinkedList {
    
   
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    public SinglyLinkedList() {
        head = null;
    }
    
    
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
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
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted " + temp.next.data + " from end");
        temp.next = null;
    }
    
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.print("List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("=== Singly Linked List Demo ===\n");
        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display();
        
        System.out.println();
        list.insertAtBeginning(5);
        list.display();
        
        System.out.println();
        list.deleteFromBeginning();
        list.display();
        
        System.out.println();
        list.deleteFromEnd();
        list.display();
    }
}