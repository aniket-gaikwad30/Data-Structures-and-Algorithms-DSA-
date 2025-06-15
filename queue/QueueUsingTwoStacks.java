import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        // Simply push to input stack
        inputStack.push(x);
    }
    
    public int pop() {
        // If output stack is empty, transfer all elements from input stack
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        
        // Pop from output stack
        return outputStack.pop();
    }
    
    public int peek() {
        // If output stack is empty, transfer all elements from input stack
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        
        // Peek from output stack
        return outputStack.peek();
    }
    
    public boolean empty() {
        // Queue is empty if both stacks are empty
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

// Main class to test the implementation
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        // Test push operation
        System.out.println("Pushing elements: 1, 2, 3");
        queue.push(1);
        queue.push(2);
        queue.push(3);
        
        // Test peek operation
        System.out.println("Peek: " + queue.peek());
        
        // Test pop operation
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        
        // Test empty operation
        System.out.println("Is queue empty? " + queue.empty());
        
        // Push more elements
        System.out.println("\nPushing more elements: 4, 5");
        queue.push(4);
        queue.push(5);
        
        // Test all operations again
        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Is queue empty? " + queue.empty());
    }
} 