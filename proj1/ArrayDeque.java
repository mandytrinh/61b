public class ArrayDeque<genericType>
{
    private genericType[] items;
    private int size; // #s of elements in deque
    private int capacity; //how many memory boxes reserved
    private int frontPointer;
    private int backPointer;
    private int resizeFactor = 2;   // factor to multiply when resizing arrays
    private double usageRatio = 0.25; // R = size/items.length

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
        return size == capacity;
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
        int startIndex = frontPointer + 1;
        int firstLength = size - startIndex; //from 1 to end

        System.arraycopy(items, startIndex, newArray, 1, firstLength);

        int secondLength = backPointer;
        System.arraycopy(items, 0, newArray, firstLength + 1, secondLength);
        // get from 0 to 1

        items = newArray;
        capacity = newCapacity;
        frontPointer = 0;
        backPointer = size + 1;
    }
    public void addFirst(genericType x)
    {
        if (arrayIsFull())
        { //'resize' by making a new array with a new capacity
            int newCapacity = capacity * resizeFactor;
            resize(newCapacity);
        }
        items[frontPointer] = x;
        frontPointer = frontPointer - 1;
        size += 1;
    }

    public void addLast(genericType x)
    {
        if (arrayIsFull())
        {
            int newCapacity = capacity * resizeFactor;
            resize(newCapacity);
        }
        items[backPointer] = x;
        backPointer = backPointer + 1;
        size += 1;

    }

}
