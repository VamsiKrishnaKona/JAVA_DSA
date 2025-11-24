package LinkedLists.DoublyLinkedList;

public class DLL_insertion
{
    private static void print(Node head)
    {
        Node curr = head;
        System.out.println();
        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail");
        System.out.println();
    }

    private static int length(Node head)
    {
        int size = 0;

        Node curr = head;

        while(curr != null)
        {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private static Node numsToDLL(int[] nums)
    {
        if(nums.length == 0) return null;

        Node head = new Node(nums[0], null, null);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node curr = new Node(nums[i], null, prev);
            prev.next = curr;
            prev = prev.next; //temp
        }
        return head;
    }

    private static Node insertAtFirst(Node head, int value)
    {
        if(head == null) return new Node(value, null, null);

        Node curr = head;
        Node prev = head.previous;

        if(prev == null)
        {
            prev = new Node(value, head, null);
            curr.previous = prev;
            head = prev;
        }
        return head;
    }

    private static Node insertAtLast(Node head, int value)
    {
        if(head == null) return new Node(value);

        Node curr = head;
        Node prev = null;

        if(curr.next == null)
        {
            curr.next = new Node(value, null, curr);
            return head;
        }

        while(curr.next != null)
        {
            prev = curr;
            curr = curr.next;
        }

        curr.next = new Node(value, null, curr);

        return head;
    }

    private static Node insertBeforeTail(Node head, int value)
    {
        if(head == null) return new Node(value, null, null);

        Node tail = head;

        if(tail.next == null)
        {
            Node temp = new Node(value, tail, null);
            tail.previous = temp;
            head = temp;
            return head;
        }

        while(tail.next != null)
        {
            tail = tail.next;
        }

        Node prev = tail.previous;

        Node curr = new Node(value, tail, prev);
        prev.next = curr;
        tail.previous = curr;

        return head;
    }

    private static Node insertAtKthPosition(Node head, int k, int value)
    {
        Node newNode = new Node(value);
        if(head == null) return newNode;

        Node curr = head;
        int idx = 0;

        while(curr != null)
        {
            idx++;
            if(idx == k) break;
            curr = curr.next;
        }

        if(k > idx) return insertAtLast(head, value);

        Node prev = curr.previous;
        Node front = curr.next;

        if(prev == null)
        {
            newNode.next = curr;
            curr.previous = newNode;
            head = newNode;
        }
        else
        {
            prev.next = newNode;
            newNode.next = curr;
            curr.previous = newNode;
            newNode.previous = prev;
            return head;
        }

        return head;
    }

    private static void insertBeforeGivenNode(Node node, int value)
    {
          if(node == null) return;

          Node prev = node.previous;

          Node temp = new Node(value, node, prev);
          prev.next = temp;
          node.previous = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4};

        Node head = numsToDLL(nums);

        //head = insertAtFirst(head, 5);

        //head = insertAtLast(head, 0);

        //head = insertBeforeTail(head, 10);

        //head = insertAtKthPosition(head,6 , 22);

        insertBeforeGivenNode(head.next.next.next, 10);

        int size = length(head);
        print(head);
        System.out.println("size : " + size);
    }
}
