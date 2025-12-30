public class ArrayCircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }
    
   
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + data);
        return data;
    }
    
    
    public boolean isFull() {
        return size == capacity;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayCircularQueue cq = new ArrayCircularQueue(5);
        
        System.out.println("=== Circular Queue Demo ===\n");
        
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.display();
        
        System.out.println();
        cq.dequeue();
        cq.dequeue();
        cq.display();
        
        System.out.println();
        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();
        
        System.out.println();
        cq.enqueue(80); 
        cq.display();
    }
}