import java.util.PriorityQueue;
import java.util.Random;

public class MergeSequenceTest {
    public static int mergeSequence(int[] sizes) {
       
        PriorityQueue<Integer> heap = new PriorityQueue<>();
       
        for (int size : sizes) {
            heap.add(size);
        }

        int totalCost = 0;

        // Process n-1 merges
        while (heap.size() > 1) {
            // Remove two smallest elements (log n time per removal)
            int first = heap.poll();
            int second = heap.poll();

            // Merge them, and add the resulting size back to the heap (log n time)
            int mergedSize = first + second;
            heap.add(mergedSize);

            // Add the merged size to the total cost
            totalCost += mergedSize;
        }

        // Return the total merge cost
        return totalCost;
    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000) + 1; // Generate random integers between 1 and 1000
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testSizes = {100, 1000, 10000, 100000, 1000000};

        for (int n : testSizes) {
            int[] listSizes = generateRandomArray(n);

            // Measure the execution time
            long startTime = System.currentTimeMillis();
            int totalCost = mergeSequence(listSizes);
            long endTime = System.currentTimeMillis();

            // Convert time to seconds
            double timeInSeconds = (endTime - startTime) / 1000.0;

            System.out.println("n = " + n + ": Total merge cost = " + totalCost + ", Time = " + timeInSeconds + " seconds");
        }
    }
}
