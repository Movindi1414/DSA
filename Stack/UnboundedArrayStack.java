
public class UnboundedArrayStack {
    private int[] array;
    private int top;
    private int capacity;
    private static final int INITIAL_CAPACITY = 2;
    
    public UnboundedArrayStack() {
        capacity = INITIAL_CAPACITY;
        array = new int[capacity];
        top = -1;
    }
    
    /**
     * Push operation 
     */
    public void push(int value) {
        // If array is full, double the capacity
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        
        array[++top] = value;
        System.out.println("Pushed: " + value + " (Capacity: " + capacity + ", Size: " + (top + 1) + ")");
    }
    
    /**
     * Pop operation 
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        int popped = array[top--];
        
        // If stack is 1/4 full and capacity > initial capacity, halve the capacity
        if (top + 1 > 0 && top + 1 == capacity / 4 && capacity > INITIAL_CAPACITY) {
            resize(capacity / 2);
        }
        
        System.out.println("Popped: " + popped + " (Capacity: " + capacity + ", Size: " + (top + 1) + ")");
        return popped;
    }
    
    /**
     * Peek operation 
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }
    
    
    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        
        // Copy elements to new array
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        
        array = newArray;
        capacity = newCapacity;
        System.out.println("Resized to capacity: " + capacity);
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        
        System.out.println("=== Testing Dynamic Growth ===");
        // Push elements to trigger resizing
        stack.push(1);
        stack.push(2);
        stack.push(3);  // Should trigger resize to 4
        stack.push(4);
        stack.push(5);  // Should trigger resize to 8
        
        stack.display();
        
        System.out.println("\n=== Testing Dynamic Shrinking ===");
        // Pop elements to trigger shrinking
        stack.pop();
        stack.pop();
        stack.pop();  // Size becomes 2, which is 1/4 of 8, should trigger resize to 4
        stack.pop();
        
        stack.display();
        
        System.out.println("\n=== Additional Operations ===");
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack capacity: " + stack.getCapacity());
    }
}