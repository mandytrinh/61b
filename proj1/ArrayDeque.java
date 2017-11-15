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
        if (size == capacity)
        {
            return true;
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void resize(int newCapacity)
    {
        genericType[] newArray = (genericType[]) new Object[newCapacity];

        System.arraycopy(items, 0, newArray, 0, size);
    }
    public void addFirst(genericType item)
    {

    }

}
