package LinkedLists.DoublyLinkedList;

public class Node
{
    public int value;
    public Node next;
    public Node previous;

    public Node(int value, Node next, Node previous)
    {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node(int value)
    {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}
