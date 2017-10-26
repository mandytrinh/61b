public class LinkedListDeque<genericType>
{
    public class Node
    {
        public genericType item;
        public Node next;
        
        public Node(Node p, genericType i, Node n)
        {
            prev = p;
            item = i;
            next = n;            
        }
    }
    
    private Node sentinel;
    private int size;
    
    public LinkedListDeque()
    {
        size = 0;
        sentinel = new Node(sentinel, null, sentinel); 
        //empty list w/ sentinel node that points at itself; previous is itself; next is itself
    }

    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int size()
    {
        return size;
    }

    public void addFirst(genericType x)
    { /*  Adds an item to the front of the Deque.
        Must not involve any looping or recursion & take constant time */
        if (this.isEmpty())
        {
            Node newFirst = new Node(sentinel, x, sentinel);
            sentinel.prev = newFirst;
        }
        else
        {
            Node oldFirst = sentinel.next;
            Node newFirst = new Node(sentinel, x, oldFirst);
            oldFirst.prev = newFirst;
        }
        sentinel.next = newFirst;
        size += 1;
    }

    public void addLast(genericType x)
    {
        if (this.isEmpty())
        {
            Node newLast = new Node(sentinel, x, sentinel);
            sentinel.next = newLast;
        }
        else
        {
            Node oldLast = sentinel.prev;
            Node newLast = new Node(oldLast, x, sentinel);
            oldLast.next = newLast;
        }
        sentinel.prev = newLast;
        size += 1;
    }
}