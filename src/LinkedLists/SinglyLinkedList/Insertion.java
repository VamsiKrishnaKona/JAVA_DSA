package LinkedLists.SinglyLinkedList;

public class Insertion
{
    private static void printLL(Node head)
    {
        Node curr = head;
        System.out.print("Head -> ");

        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }

        System.out.print(" Tail");
    }

    private static int length(Node head)
    {
        int len = 0;

        Node temp = head;

        while(temp != null)
        {
            len += 1;
            temp = temp.next;
        }
        return len;
    }

    private static Node getHead(int[] nums)
    {
        if(nums.length < 1) return null;

        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static Node insertAtFirst(Node head, int value)
    {
        if(head == null)
        {
            head = new Node(value);
            return head;
        }

        Node curr = head;
        head = new Node(value);
        head.next = curr;

        return head;
    }

    private static Node insertAtLast(Node head, int value)
    {
        if(head == null)
        {
            head = new Node(value);
            return head;
        }

        Node curr = head;

        while(curr.next.next != null)
        {
            curr = curr.next;
        }

        curr.next.next = new Node(value);

        return head;
    }

    private static Node insertAtKthNode(Node head, int k, int value)
    {
        if(head == null || k <= 1)
        {
            return insertAtFirst(head, value);
        }

        int size = length(head);

        if(k > size)
        {
            return head = insertAtLast(head, value);
        }

        Node prev = head;
        Node curr = head.next;

        int idx = 2;

        while(curr != null)
        {
            if(idx == k)
            {
                prev.next = new Node(value);
                prev.next.next = curr;
                return head;
            }
            prev = prev.next;
            curr = curr.next;
            idx += 1;
        }

        return head;
    }

    private static Node insertElementBeforeValue(Node head, int element, int value)
    {
         if(head == null) return null;

         if(head.value == value)
         {
             Node curr = head;
             head = new Node(element);
             head.next = curr;
             return head;
         }

         Node prev = head;
         Node curr = head.next;

         while(curr != null)
         {
             if(curr.value == value)
             {
                 prev.next = new Node(element);
                 prev.next.next = curr;
                 break;
             }

             prev = prev.next;
             curr = curr.next;
         }

         return head;
    }
    
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};

        Node head = getHead(nums);

        //head = insertAtFirst(head, 0);

        //head = insertAtLast(head, 7);

        //head = insertAtKthNode(head, 7, 99);

        head = insertElementBeforeValue(head, 42, 1);

        printLL(head);
    }
}
