import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test Case 1: 'aabc'");
        findFirstNonRepeating("aabc");
        
        // Test case 2
        System.out.println("\nTest Case 2: 'aac'");
        findFirstNonRepeating("aac");
        
        // Test case 3
        System.out.println("\nTest Case 3: 'aabbcc'");
        findFirstNonRepeating("aabbcc");
    }
    
    public static void findFirstNonRepeating(String str) {
        // Array to store character counts
        int[] charCount = new int[26];
        // Queue to store characters in order
        Queue<Character> queue = new LinkedList<>();
        
        // Process each character in the stream
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // Increment count for current character
            charCount[c - 'a']++;
            
            // Add character to queue
            queue.add(c);
            
            // Process queue to find first non-repeating character
            while (!queue.isEmpty() && charCount[queue.peek() - 'a'] > 1) {
                queue.remove();
            }
            
            // Print result
            if (queue.isEmpty()) {
                System.out.println("First non-repeating character so far: -1");
            } else {
                System.out.println("First non-repeating character so far: " + queue.peek());
            }
        }
    }
} 