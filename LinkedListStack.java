public class LinkedListStack {
    
    // Node class for the stack
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top;
    private int size;
    
    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }
    
    // Push element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Pushed: " + data);
    }
    
    // Pop element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1;
        }
        
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }
    
    // Peek at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get the size of the stack
    public int getSize() {
        return size;
    }
    
    // Display all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Clear the entire stack
    public void clear() {
        top = null;
        size = 0;
        System.out.println("Stack cleared");
    }
    
    // Search for an element in the stack
    public boolean search(int data) {
        Node current = top;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get element at a specific position from top (0-indexed)
    public int getElementAt(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return -1;
        }
        
        Node current = top;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        System.out.println("=== Linked List Stack Demo ===\n");
        
        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println();
        stack.display();
        System.out.println("Size: " + stack.getSize());
        
        // Peek
        System.out.println("\nPeek top element: " + stack.peek());
        
        // Pop elements
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        System.out.println();
        stack.display();
        System.out.println("Size: " + stack.getSize());
        
        // Search
        System.out.println("\nSearching for 30: " + stack.search(30));
        System.out.println("Searching for 100: " + stack.search(100));
        
        // Get element at position
        System.out.println("\nElement at position 1: " + stack.getElementAt(1));
        
        // Push more elements
        System.out.println("\nPushing more elements:");
        stack.push(60);
        stack.push(70);
        
        System.out.println();
        stack.display();
        
        // Clear stack
        System.out.println();
        stack.clear();
        stack.display();
        System.out.println("Size after clear: " + stack.getSize());
        
        // Try to pop from empty stack
        System.out.println("\nTrying to pop from empty stack:");
        stack.pop();
    }
}