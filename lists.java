import java.util.PriorityQueue;
import java.util.Random;

public class OptimalMerge {

  
    public static int optimalMerge(int[] listSizes) {
       
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int size : listSizes) {
            minHeap.add(size);
        }
        int totalCost = 0;
        while (minHeap.size() > 1) {
    
            int first = minHeap.poll();  
            int second = minHeap.poll(); 
            int mergedSize = first + second;
            minHeap.add(mergedSize);
            totalCost += mergedSize;
        }
        return totalCost; 
    }

    public static void main(String[] args) {
       
        int[] arraySizes = {100, 1000, 10000, 100000, 1000000};
        Random rand = new Random(); 

        // Iterate through the different array sizes
        for (int n : arraySizes) {
            // Create an array of size n with random sizes for merging
            int[] listSizes = new int[n];
            for (int i = 0; i < n; i++) {
                listSizes[i] = rand.nextInt(100) + 1; // Random size between 1 and 100
            }

            // Measure execution time
            long startTime = System.nanoTime();
            int totalCost = optimalMerge(listSizes);
            long endTime = System.nanoTime();

            // Calculate duration in nanoseconds
            long duration = endTime - startTime;

            // Print the results
            System.out.println("Total cost of merging " + n + " lists: " + totalCost + "M");
            System.out.println("Execution time for " + n + " lists: " + duration + " nanoseconds");
        }
    }
}
