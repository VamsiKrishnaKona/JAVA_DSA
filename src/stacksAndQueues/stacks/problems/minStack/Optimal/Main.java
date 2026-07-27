package stacksAndQueues.stacks.problems.minStack.Optimal;

public class Main
{
    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(12);

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());

        minStack.push(15);

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());

        minStack.push(10);

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());

        System.out.println(minStack);

        minStack.pop();

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());

        minStack.pop();

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());

        minStack.pop();

        System.out.println("min : " + minStack.minimum());
        System.out.println("Peak : " + minStack.peak());
    }
}
