public class BubbleSort {
    
    // Function to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        
        System.out.println("Starting Bubble Sort...\n");
        
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            
            // Inner loop for comparisons
            for (int j = 0; j < n - 1; j++) {
                comparisons++;
                
                // Swap if current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    System.out.println("  Swapped " + arr[j + 1] + " and " + arr[j]);
                }
            }
            
            System.out.print("  Array after pass " + (i + 1) + ": ");
            printArray(arr);
            System.out.println();
        }
        
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);
    }
    
    // Function to print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("=== Bubble Sort Algorithm ===\n");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println();
        
        bubbleSort(arr);
        
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
    }
}