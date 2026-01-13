public class HanoiTower {
    
    // Counter for number of moves
    private static int moveCount = 0;
    
    // Main function to solve Tower of Hanoi
    public static void solveHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            moveCount++;
            System.out.println("Move " + moveCount + ": Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary using destination
        solveHanoi(n - 1, source, auxiliary, destination);
        
        // Move the nth disk from source to destination
        moveCount++;
        System.out.println("Move " + moveCount + ": Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination using source
        solveHanoi(n - 1, auxiliary, destination, source);
    }
    
    public static void main(String[] args) {
        int numberOfDisks = 3;
        
        System.out.println("=== Tower of Hanoi ===");
        System.out.println("Number of disks: " + numberOfDisks);
        System.out.println("Source: A, Destination: C, Auxiliary: B\n");
        
        solveHanoi(numberOfDisks, 'A', 'C', 'B');
        
        System.out.println("\nTotal moves: " + moveCount);
        System.out.println("Formula: 2^n - 1 = 2^" + numberOfDisks + " - 1 = " + (Math.pow(2, numberOfDisks) - 1));
    }
}