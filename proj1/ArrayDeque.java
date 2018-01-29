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

	public int getCapacity() { return capacity; }

	private boolean arrayIsFull() { return size == capacity; }

    public int size() {return size; }

    public boolean isEmpty() { return size == 0; }

	public void maintainUsageFactor()
	{
		if (capacity >= 16)
		{
			double usageFactor = (size + 0.0)/capacity; // implicit casting to a double
			if (usageFactor < usageRatio) //usageRatio is 0.25
			{
				int newCapacity = capacity / resizeFactor; // when we fall below that, half the capacity (aka length) by 2 (aka resizefactor)
				resizeDown(newCapacity);
			}
		}
	}

	private int addOne(int currentIndex)
    {
        int nextIndex = currentIndex + 1;
        if (nextIndex == capacity)
        {
            nextIndex = nextIndex % capacity;
        }
        return nextIndex;
    }

    private int minusOne(int currentIndex)
    {
        int nextIndex = currentIndex - 1;
        if (nextIndex < 0)
        {
            nextIndex = nextIndex + capacity;
        }
        return nextIndex;
    }

	private void resizeDown(int newCapacity)
    {
        genericType[] newArray = (genericType[]) new Object[newCapacity];
        System.arraycopy(items, 1, newArray, 1, size);
        items = newArray;
        capacity = newCapacity;
        frontPointer = 0;
        backPointer = size + 1;

    }
	
    private void resizeUp(int newCapacity)
    {
        genericType[] newArray = (genericType[]) new Object[newCapacity];
        int startIndex = addOne(frontPointer);
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
            resizeUp(newCapacity);
        }
        items[frontPointer] = x;
        frontPointer = minusOne(frontPointer);
        size += 1;
    }

    public void addLast(genericType x)
    {
        if (arrayIsFull())
        {
            int newCapacity = capacity * resizeFactor;
            resizeUp(newCapacity);
        }
        items[backPointer] = x;
        backPointer = addOne(backPointer);
        size += 1;

    }

    public genericType get(int index)
    {
        //Gets the item at the given index, where 0 is the front, 1 is the next item etc.
        // If no such item exists, returns null.
        if (index >= size)
        {
            return null;
        }
        else
        {
            int realIndex = (index + frontPointer + 1) % capacity;
            return items[realIndex]; //return corresponding item at the given index
        }
    }

    private void set(int index, genericType x)
    {
        int realIndex = (index + frontPointer + 1) % capacity;
        items[realIndex] = x;
    }

    public genericType removeFirst()
    {
        // Removes & returns the item at the front of Deque. If no such item exists, returns null.
        if (isEmpty())
        {
            return null;
        }
        genericType firstItem = get(0); //get item at index 0
        set(0, null); // nulls out item at 0th index
        frontPointer = frontPointer + 1;
        size -= 1;
		maintainUsageFactor();
        return firstItem;
    }

    public genericType removeLast()
    {
        // Removes & returns the item at the back of Deque. If no such item exists, returns null.
        if (isEmpty())
        {
            return null;
        }
        genericType lastItem = get(size - 1);
        set(size - 1, null);
        backPointer = backPointer - 1;
        size -= 1;
        maintainUsageFactor();

        return lastItem;
    }

    public void printDeque()
    {
        // Prints the items in the Deque from first to last, separated by a space.
        for (int i = 0; i < size; i++)
        {
            System.out.print(get(i) + " ");
        }
    }
}
