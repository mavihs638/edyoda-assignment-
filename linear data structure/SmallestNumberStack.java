import java.util.Stack;

public class SmallestNumberStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public SmallestNumberStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value < minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        minStack.pop();
        return stack.pop();
    }

    public int getMinimum() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        SmallestNumberStack smallestNumberStack = new SmallestNumberStack();

        smallestNumberStack.push(3);
        smallestNumberStack.push(5);
        smallestNumberStack.push(2);
        smallestNumberStack.push(8);

        System.out.println("Current minimum: " + smallestNumberStack.getMinimum()); // Output: 2

    }
}
