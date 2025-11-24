package LL;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertAtFirst(30);
        list.insertAtFirst(20);
        list.insertAtFirst(10);

        list.insertLast(40);

        list.insert(25,2);

        list.display();

        list.deleteFirst();

        list.display();




    }
}
