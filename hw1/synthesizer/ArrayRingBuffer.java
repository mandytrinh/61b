package synthesizer;
import java.util.Iterator;

// make this class and all of its methods public
// make this class extend AbstractBoundedQueue<T>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    public int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    public int last;
    /* Array for storing the buffer data. */
    public T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.rb = (T[]) new Object[capacity];
        this.first = 0; this.last = 0; this.fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is NO ROOM, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        // Adds item to the back, & increase fillCount and update last.
        if (isFull())
        {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        this.last += 1;
        if (this.last == capacity)
        {
            this.last = 0;
        }
        this.fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is EMPTY, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // Returns the first (OLDEST) added item & decrease fillCount and update
        if (isEmpty())
        {
            throw new RuntimeException("Ring buffer underflow");
        }
        T itemToReturn = rb[first];
        this.first += 1;
        if (this.first == capacity)
        {
            this.first = 0;
        }
        this.fillCount -= 1;
        return itemToReturn;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty())
        {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
