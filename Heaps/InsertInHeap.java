import java.util.ArrayList;

public class InsertInHeap {

    public static void insert(ArrayList<Integer> pq, int data) {


        pq.add(data);
        int childIndex = pq.size() - 1;

       
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;

            // If child is smaller than parent, swap
            if (pq.get(childIndex) < pq.get(parentIndex)) {
                int temp = pq.get(parentIndex);
                pq.set(parentIndex, pq.get(childIndex));
                pq.set(childIndex, temp);

                // Move up the tree
                childIndex = parentIndex;
            } else {
                break; // Heap property satisfied
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> minHeap = new ArrayList<>();

        // Test insertions
        insert(minHeap, 10);
        insert(minHeap, 5);
        insert(minHeap, 14);
        insert(minHeap, 2);
        insert(minHeap, 8);

        System.out.println("Min-Heap after insertions: " + minHeap);

        }
}
