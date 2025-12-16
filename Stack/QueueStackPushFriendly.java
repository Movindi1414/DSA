import java.util.LinkedList;
import java.util.Queue;


public class QueueStackPushFriendly {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    
    public void push(int value) {
        q1.offer(value);
        System.out.println("Pushed: " + value);
    }
    
    
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Move all elements except the last one to q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        
        // The last element in q1 is our top element
        int popped = q1.poll();
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
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
        
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        
        int top = q1.peek();
        q2.offer(q1.poll());
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return top;
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    public int size() {
        return q1.size();
    }
    
    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        
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