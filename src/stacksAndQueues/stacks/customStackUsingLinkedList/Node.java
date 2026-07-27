package stacksAndQueues.stacks.customStackUsingLinkedList;

public class Node
{
    Object data;
    Node next;

    public Node()
    {
        this.data = null;
        this.next = null;
    }

    public Node(Object data)
    {
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
