public class RabbitProblem {
    
    // Method 1: Recursive approach (simple but inefficient for large n)
    public static long fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Method 2: Iterative approach 
    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        long prev2 = 1; // F(1)
        long prev1 = 1; // F(2)
        long current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    // Method 3: Dynamic Programming with Memoization
    public static long fibonacciMemoization(int n, long[] memo) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        if (memo[n] != -1) {
            return memo[n];
        }
        
        memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
        return memo[n];
    }
    
    // Method 4: Display rabbit population growth
    public static void displayRabbitGrowth(int months) {
        System.out.println("\n=== Rabbit Population Growth ===");
        System.out.println("Month\tBaby Pairs\tAdult Pairs\tTotal Pairs");
        System.out.println("-----\t----------\t-----------\t-----------");
        
        long[] babyPairs = new long[months + 1];
        long[] adultPairs = new long[months + 1];
        long[] totalPairs = new long[months + 1];
        
        // Initial state: 1 pair of baby rabbits
        babyPairs[1] = 1;
        adultPairs[1] = 0;
        totalPairs[1] = 1;
        
        System.out.printf("%d\t%d\t\t%d\t\t%d\n", 1, babyPairs[1], adultPairs[1], totalPairs[1]);
        
        for (int month = 2; month <= months; month++) {
            // Baby rabbits from last month become adults
            // Adult rabbits produce new baby pairs
            adultPairs[month] = adultPairs[month - 1] + babyPairs[month - 1];
            babyPairs[month] = adultPairs[month - 1];
            totalPairs[month] = babyPairs[month] + adultPairs[month];
            
            System.out.printf("%d\t%d\t\t%d\t\t%d\n", month, babyPairs[month], 
                            adultPairs[month], totalPairs[month]);
        }
    }
    
    // Method 5: Calculate rabbit pairs at specific month
    public static void calculateRabbitPairs(int month) {
        long pairs = fibonacciIterative(month);
        System.out.println("\nAfter " + month + " month(s), there will be " + pairs + " pair(s) of rabbits.");
    }
    
    // Method 6: Display Fibonacci sequence up to n terms
    public static void displayFibonacciSequence(int terms) {
        System.out.println("\n=== Fibonacci Sequence (First " + terms + " terms) ===");
        System.out.print("Sequence: ");
        
        for (int i = 1; i <= terms; i++) {
            System.out.print(fibonacciIterative(i));
            if (i < terms) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }
    
    // Method 7: Find the month when rabbit pairs exceed a target
    public static int findMonthExceedingTarget(long target) {
        int month = 1;
        long pairs = 1;
        
        while (pairs <= target) {
            month++;
            pairs = fibonacciIterative(month);
        }
        
        return month;
    }
    
    // Method 8: Calculate growth rate between consecutive months
    public static void displayGrowthRate(int months) {
        System.out.println("\n=== Rabbit Population Growth Rate ===");
        System.out.println("Month\tPairs\tGrowth Rate");
        System.out.println("-----\t-----\t-----------");
        
        long prevPairs = fibonacciIterative(1);
        System.out.printf("%d\t%d\t-\n", 1, prevPairs);
        
        for (int month = 2; month <= months; month++) {
            long currentPairs = fibonacciIterative(month);
            double growthRate = ((double)(currentPairs - prevPairs) / prevPairs) * 100;
            System.out.printf("%d\t%d\t%.2f%%\n", month, currentPairs, growthRate);
            prevPairs = currentPairs;
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   RABBIT PROBLEM (FIBONACCI SEQUENCE)");
        System.out.println("========================================");
        
        int months = 10;
        
        // Display Fibonacci sequence
        displayFibonacciSequence(months);
        
        // Display detailed rabbit growth
        displayRabbitGrowth(months);
        
        // Calculate pairs at specific month
        calculateRabbitPairs(6);
        calculateRabbitPairs(12);
        
        // Display growth rate
        displayGrowthRate(8);
        
        // Find when population exceeds target
        long target = 100;
        int monthExceeding = findMonthExceedingTarget(target);
        System.out.println("\nRabbit pairs will exceed " + target + " in month " + monthExceeding);
        System.out.println("Pairs in month " + monthExceeding + ": " + fibonacciIterative(monthExceeding));
        
        // Compare performance of different methods
        System.out.println("\n=== Performance Comparison ===");
        int testMonth = 40;
        
        // Iterative (efficient)
        long startTime = System.nanoTime();
        long resultIterative = fibonacciIterative(testMonth);
        long endTime = System.nanoTime();
        System.out.println("Iterative - Month " + testMonth + ": " + resultIterative);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        
        // Memoization
        startTime = System.nanoTime();
        long[] memo = new long[testMonth + 1];
        for (int i = 0; i <= testMonth; i++) {
            memo[i] = -1;
        }
        long resultMemo = fibonacciMemoization(testMonth, memo);
        endTime = System.nanoTime();
        System.out.println("\nMemoization - Month " + testMonth + ": " + resultMemo);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        
        // Note: Recursive method is too slow for large n, so we skip it for n=40
        System.out.println("\n(Recursive method skipped for large n due to exponential time complexity)");
    }
}