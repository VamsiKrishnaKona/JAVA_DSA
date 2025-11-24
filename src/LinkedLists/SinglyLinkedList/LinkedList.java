package LinkedLists.SinglyLinkedList;

public class LinkedList
{
    private static Node numsToLL(int[] nums)
    {
        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1 ; i < nums.length; i++)
        {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
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

    private static boolean findInLL(Node head, int target)
    {
        Node temp = head;

        while(temp != null)
        {
            if(temp.value == target)
            {
                return true;
            }

            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7};
        int target = 7;

        Node head = numsToLL(nums);

        //int size = length(head);
        //System.out.print(size);

        boolean isPresent = findInLL(head, target);

        System.out.println(isPresent);

    }
}
