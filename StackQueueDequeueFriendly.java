import java.util.Stack;

public class StackQueueDequeueFriendly {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 
    
    public StackQueueDequeueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued: " + data);
    }
    
    
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = stack2.pop();
        System.out.println("Dequeued: " + data);
        return data;
    }
    
    
    public void display() {
        System.out.print("Queue: ");
        if (!stack2.isEmpty()) {
            System.out.print(stack2 + " ");
        }
        if (!stack1.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack1.isEmpty()) {
                temp.push(stack1.pop());
            }
            System.out.print(temp);
            while (!temp.isEmpty()) {
                stack1.push(temp.pop());
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        StackQueueDequeueFriendly sq = new StackQueueDequeueFriendly();
        
        System.out.println("=== Stack Queue Demo ===\n");
        
        sq.enqueue(10);
        sq.enqueue(20);
        sq.enqueue(30);
        sq.display();
        
        System.out.println();
        sq.dequeue();
        sq.dequeue();
        sq.display();
        
        System.out.println();
        sq.enqueue(40);
        sq.enqueue(50);
        sq.display();
        
        System.out.println();
        sq.dequeue();
        sq.display();
    }
}