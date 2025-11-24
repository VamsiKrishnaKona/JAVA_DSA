package LinkedLists.doublyLinkedListWithChild;

public class Node
{
    public int value;
    public Node next;
    public Node prev;
    public Node child;

    public Node()
    {
        this.next = null;
        this.prev = null;
        this.child = null;
    }

    public Node(int value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.child = null;
    }
}
