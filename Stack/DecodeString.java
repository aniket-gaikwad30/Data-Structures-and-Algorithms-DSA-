import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }

                stack.pop(); // remove the '['

                int count = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count = (stack.pop() - '0') * base + count;
                    base *= 10;
                }

                String repeated = sb.toString().repeat(count);
                for (char c : repeated.toCharArray()) {
                    stack.push(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        String encoded = "3[a2[c]]";
        String decoded = decoder.decodeString(encoded);
        System.out.println(decoded); // Output: accaccacc
    }
}
