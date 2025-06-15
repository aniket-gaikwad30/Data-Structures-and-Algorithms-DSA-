public class QueueImplementation {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue
    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return Integer.MIN_VALUE;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Method to get the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return queue[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation(5);

        // Test enqueue operation
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Try to enqueue when queue is full
        queue.enqueue(60);

        // Test dequeue operation
        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println(queue.dequeue() + " dequeued from queue");

        // Test peek operation
        System.out.println("Front element is " + queue.peek());

        // Test size operation
        System.out.println("Queue size is " + queue.size());

        // Test isEmpty operation
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
} 