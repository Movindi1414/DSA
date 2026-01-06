public class LinkedListFIFOQueue {
    
    // Node class for the queue
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front;
    private Node rear;
    private int size;
    
    public LinkedListFIFOQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    // Enqueue - Add element to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + data);
    }
    
    // Dequeue - Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        
        int dequeuedData = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        return dequeuedData;
    }
    
    // Peek at the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    
    // Peek at the rear element
    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return rear.data;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Get the size of the queue
    public int getSize() {
        return size;
    }
    
    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Clear the entire queue
    public void clear() {
        front = null;
        rear = null;
        size = 0;
        System.out.println("Queue cleared");
    }
    
    // Search for an element in the queue
    public boolean search(int data) {
        Node current = front;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get element at a specific position from front (0-indexed)
    public int getElementAt(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return -1;
        }
        
        Node current = front;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Get position of an element (returns -1 if not found)
    public int getPosition(int data) {
        Node current = front;
        int position = 0;
        
        while (current != null) {
            if (current.data == data) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();
        
        System.out.println("=== Linked List FIFO Queue Demo ===\n");
        
        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        System.out.println();
        queue.display();
        System.out.println("Size: " + queue.getSize());
        
        // Peek
        System.out.println("\nPeek front element: " + queue.peek());
        System.out.println("Peek rear element: " + queue.peekRear());
        
        // Dequeue elements
        System.out.println("\nDequeuing elements:");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        System.out.println();
        queue.display();
        System.out.println("Size: " + queue.getSize());
        
        // Search
        System.out.println("\nSearching for 30: " + queue.search(30));
        System.out.println("Searching for 100: " + queue.search(100));
        
        // Get element at position
        System.out.println("\nElement at position 1: " + queue.getElementAt(1));
        
        // Get position of element
        System.out.println("Position of element 40: " + queue.getPosition(40));
        
        // Enqueue more elements
        System.out.println("\nEnqueuing more elements:");
        queue.enqueue(60);
        queue.enqueue(70);
        
        System.out.println();
        queue.display();
        
        // Dequeue all
        System.out.println("\nDequeuing all elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        
        System.out.println();
        queue.display();
        System.out.println("Size after dequeuing all: " + queue.getSize());
        
        // Try to dequeue from empty queue
        System.out.println("\nTrying to dequeue from empty queue:");
        queue.dequeue();
        
        // Add elements again and clear
        System.out.println("\nAdding elements and clearing:");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.display();
        queue.clear();
        queue.display();
    }
}