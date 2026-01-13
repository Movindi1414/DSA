public class OptimizedBubbleSort {
    
    // Function to perform optimized bubble sort
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        boolean swapped;
        
        System.out.println("Starting Optimized Bubble Sort...\n");
        
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("Pass " + (i + 1) + ":");
            
            // Inner loop reduced by i (last i elements are already sorted)
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                
                // Swap if current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                    System.out.println("  Swapped " + arr[j + 1] + " and " + arr[j]);
                }
            }
            
            System.out.print("  Array after pass " + (i + 1) + ": ");
            printArray(arr);
            
            // If no swapping occurred, array is already sorted
            if (!swapped) {
                System.out.println("  No swaps made - Array is sorted!");
                break;
            }
            System.out.println();
        }
        
        System.out.println("\nTotal comparisons: " + comparisons);
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
        
        System.out.println("=== Optimized Bubble Sort Algorithm ===\n");
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println();
        
        optimizedBubbleSort(arr);
        
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
        
        // Example with already sorted array
        System.out.println("\n\n=== Test with Already Sorted Array ===\n");
        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        printArray(sortedArr);
        System.out.println();
        optimizedBubbleSort(sortedArr);
    }
}