public class ArrayDeque<genericType>
{
    private genericType[] items;
    private int size;
    private int frontPointer;
    private int backPointer;

    // Initializes empty array deque w/ starting size 8
    public ArrayDeque()
    {
        items = (genericType[]) new Object[8];
    }
}
