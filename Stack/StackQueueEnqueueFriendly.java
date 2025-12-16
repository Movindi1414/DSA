import java.util.Stack;


public class StackQueueEnqueueFriendly {
    private Stack<Integer> enqueueStack;  // Stack for enqueue operations
    private Stack<Integer> dequeueStack;  // Stack for dequeue operations
    
    public StackQueueEnqueueFriendly() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }
    
    
    public void enqueue(int value) {
        enqueueStack.push(value);
        System.out.println("Enqueued: " + value);
    }
    
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // If dequeueStack is empty, transfer all elements from enqueueStack
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        
        int dequeued = dequeueStack.pop();
        System.out.println("Dequeued: " + dequeued);
        return dequeued;
    }
    
    /**
     * Peek operation 
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        
        return dequeueStack.peek();
    }
    
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
    
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        
        // Display dequeueStack from top to bottom (these are at front)
        Stack<Integer> tempStack = new Stack<>();
        while (!dequeueStack.isEmpty()) {
            int val = dequeueStack.pop();
            System.out.print(val + " ");
            tempStack.push(val);
        }
        
        // Restore dequeueStack
        while (!tempStack.isEmpty()) {
            dequeueStack.push(tempStack.pop());
        }
        
        // Display enqueueStack from bottom to top (these are at rear)
        tempStack.clear();
        while (!enqueueStack.isEmpty()) {
            tempStack.push(enqueueStack.pop());
        }
        
        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            System.out.print(val + " ");
            enqueueStack.push(val);
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();
        
        // Test case from PDF
        System.out.println("=== Test Case ===");
        queue.enqueue(3);
        queue.enqueue(5);
        queue.dequeue();  // Should return 3
        queue.enqueue(7);
        queue.dequeue();  // Should return 5
        queue.dequeue();  // Should return 7
        
        System.out.println("\n=== Additional Test ===");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.dequeue();
        queue.enqueue(40);
        queue.display();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}