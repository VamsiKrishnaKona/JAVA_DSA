package stacksAndQueues.queues.customQueueUsingArray;

public class Main
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new Queue<>();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("size : " + queue.size());
        System.out.println(queue);
        System.out.println(queue.top());

        queue.pop();
        //queue.pop();

        System.out.println("size : " + queue.size());
        System.out.println(queue);
        System.out.println(queue.top());

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(10);

        System.out.println("size : " + queue.size());
        System.out.println(queue);
        System.out.println(queue.top());
    }
}
