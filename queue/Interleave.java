import java.util.Queue;
import java.util.LinkedList;

public class Interleave {

    public static void interlink(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            System.out.println("Queue must have even number of elements");
            return;
        }

        Queue<Integer> first = new java.util.LinkedList<Integer>();
        int size = q.size();

        // Step 1: Push first half elements into 'first'
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }

        // Step 2: Interleave the elements of first and second half
        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }

        interlink(q);
        System.out.println("Interleaved Queue: " + q);
    }
}
