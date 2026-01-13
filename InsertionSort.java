public class InsertionSort {
    
    // Function to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int shifts = 0;
        
        System.out.println("Starting Insertion Sort...\n");
        
        // Start from second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            System.out.println("Step " + i + ": Insert " + key + " into sorted portion");
            System.out.print("  Before: ");
            printArray(arr);
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                shifts++;
                j--;
            }
            
            if (j >= 0) {
                comparisons++;
            }
            
            arr[j + 1] = key;
            
            System.out.print("  After:  ");
            printArray(arr);
            System.out.println("  Inserted " + key + " at position " + (j + 1));
            System.out.println();
        }
        
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total shifts: " + shifts);
    }
    
    // Function to print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Function to print array with visual separator
    public static void printArrayWithSeparator(int[] arr, int sortedIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (i == sortedIndex) {
                System.out.print("| ");
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("=== Insertion Sort Algorithm ===\n");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println();
        
        insertionSort(arr);
        
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
        
        // Example with another array
        System.out.println("\n\n=== Another Example ===\n");
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        System.out.print("Original array: ");
        printArray(arr2);
        System.out.println();
        insertionSort(arr2);
        System.out.print("\nFinal sorted array: ");
        printArray(arr2);
    }
}