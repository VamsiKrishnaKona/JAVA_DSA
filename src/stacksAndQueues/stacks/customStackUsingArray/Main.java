package stacksAndQueues.stacks.customStackUsingArray;

public class Main
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();

        java.util.Stack<String> st = new java.util.Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");
        stack.push("K");

        stack.add(1, "a");

        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.size());
    }
}
