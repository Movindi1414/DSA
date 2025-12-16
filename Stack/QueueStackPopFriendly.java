import java.util.LinkedList;
import java.util.Queue;


public class QueueStackPopFriendly {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public QueueStackPopFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    
    public void push(int value) {
        // Add new element to q2
        q2.offer(value);
        
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        System.out.println("Pushed: " + value);
    }
    
    /**
     * Pop operation  
     */
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        int popped = q1.poll();
        System.out.println("Popped: " + popped);
        return popped;
    }
    
    /**
     * Peek operation 
     */
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        return q1.peek();
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    public int size() {
        return q1.size();
    }
    
    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        
        // Test case from PDF
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.pop();  // Should return 7
        stack.push(9);
        stack.pop();  // Should return 9
        stack.pop();  // Should return 5
        
        System.out.println("\nRemaining size: " + stack.size());
    }
}