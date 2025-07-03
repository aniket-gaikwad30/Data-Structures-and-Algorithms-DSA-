import java.util.*;

public class PriorityQueueDemo {

    static class Students implements Comparable<Students> {
        String name;
        int rank;

        Students(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Students other) {
            return Integer.compare(this.rank, other.rank);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(30);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // poll() returns and removes the head
        }

        // Using custom objects with PriorityQueue
        PriorityQueue<Students> studentQueue = new PriorityQueue<>();
        studentQueue.add(new Students("Alice", 2));
        studentQueue.add(new Students("Bob", 1));
        studentQueue.add(new Students("Charlie", 3));       
        studentQueue.add(new Students("Diana", 0));
        studentQueue.add(new Students("Eve", 4));
        while (!studentQueue.isEmpty()) {
            Students student = studentQueue.poll();  // poll() returns and removes the head
            System.out.println(student.name + " with rank " + student.rank);
        }
    }
}
