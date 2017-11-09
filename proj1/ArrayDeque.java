public class ArrayDeque<genericType>
{
    private genericType[] items;
    private int size; // #s of elements in deque
    private int capacity; //how many memory boxes reserved
    private int frontPointer;
    private int backPointer;
    private int resizeFactor = 2;   // Resize factor to multiply when resizing arrays
    private double usageRatio = 0.25; //R = size/items.length

    // Initializes empty array deque with starting capacity 8

    public ArrayDeque()
    {
        items = (genericType[]) new Object[8];
        size = 0;
        capacity = 8;
        backPointer = 1;
        frontPointer = 0;
    }

    private boolean arrayIsFull()
    {
        if (this.size == this.capacity)
        {
            return true;
        }
        return false;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

}
