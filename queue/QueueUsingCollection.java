import java.util.Queue;
import java.util.LinkedList;

public class QueueUsingCollection {
    public static void main(String[] args) {
        // Create a queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        System.out.println("Adding elements to the queue:");
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        // Display the queue
        System.out.println("Queue elements: " + queue);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Remove elements from the queue
        System.out.println("\nRemoving elements from the queue:");
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());

        // Display the queue after removal
        System.out.println("Queue after removal: " + queue);

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Get the size of the queue
        System.out.println("Queue size: " + queue.size());

        // Using offer() method (safer than add())
        System.out.println("\nUsing offer() method:");
        queue.offer(60);
        queue.offer(70);
        System.out.println("Queue after offer: " + queue);

        // Using poll() method (safer than remove())
        System.out.println("\nUsing poll() method:");
        System.out.println("Polled element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Demonstrate element() method
        System.out.println("\nUsing element() method:");
        System.out.println("Front element: " + queue.element());
    }
} 