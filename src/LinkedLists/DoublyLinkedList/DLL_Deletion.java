package LinkedLists.DoublyLinkedList;

public class DLL_Deletion
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
        if(nums.length <= 0) return null;

        Node head = new Node(nums[0], null, null);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i], null, prev);
            prev.next = temp;
            prev = prev.next; //temp
        }
        return head;
    }

    private static Node deleteHead(Node head)
    {
        if(head == null || head.next == null ) return null;

        Node prev = head;

        head = head.next;
        head.previous = null;
        prev.next = null;
        return head;
    }

    private static Node deleteTail(Node head)
    {
        if(head == null || head.next == null ) return null;

        Node curr = head;

        while(curr.next.next != null)
        {
            curr = curr.next;
        }

        curr.next.previous = null;
        curr.next = null;

        return head;
    }

    private static Node deleteElementAtKthNode(Node head, int k)
    {
        if(head == null || head.next == null && head.previous == null) return null;

        Node curr = head;
        int idx = 0;

        while(curr != null)
        {
            idx++;
            if(k == idx) break;
            curr = curr.next;
        }

        Node prev = curr.previous;
        Node front = curr.next;

        if(prev == null)
        {
            return deleteHead(head);
        }
        else if(front == null)
        {
            return deleteTail(head);
        }
        else
        {
            prev.next = front;
            front.previous = prev;
            curr.next = null;
            curr.previous = null;
        }

        return head;
    }

    private static void deleteNodewithGivenNode(Node node) //head wont be a given node
    {
        if(node == null) return;

        Node front = node.next;
        Node prev = node.previous;

        if(front == null && prev == null) return;

        if(front == null)
        {
            prev.next = null;
            node.previous = null;
        }

        prev.next = front;
        front.previous = prev;
        node.next = null;
        node.previous = null;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4};

        Node head = numsToDLL(nums);



        //head = deleteHead(head);

        //head = deleteTail(head);

        //head = deleteElementAtKthNode(head, 2);

        deleteNodewithGivenNode(head.next.next);

        int size = length(head);
        print(head);
        System.out.println("size : " + size);
    }
}
