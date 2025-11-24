package LinkedLists.singlyLL_withChild;

public class Node
{
    public int value;
    public Node next;
    public Node child;

    public Node()
    {
        this.next = null;
        this.child = null;
    }

    public Node(int value)
    {
        this.value = value;
        this.next = null;
        this.child = null;
    }
}
