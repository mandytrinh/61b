package synthesizer;

public class GuitarString {
    /** Constants. The keyword final means
     * the values cannot be changed at runtime.  */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    // Create a guitar string of the given frequency.
    public GuitarString(double frequency) {
        /* Create a buffer with capacity = SR / frequency. You'll need to
               cast the result of this division operation into an int. For better
               accuracy, use the Math.round() function before casting.
               Your buffer should be initially filled with zeros. */
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        while (!buffer.isFull())
        {
            buffer.enqueue(0.0);
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        /* Dequeue everything in the buffer, and replace it with random numbers
               between -0.5 and 0.5. You can get such a number by using:
               double r = Math.random() - 0.5;
               Make sure that your random numbers are different from each other.*/
        double r = Math.random() - 0.5;
        while (!buffer.isEmpty())
        {
            buffer.dequeue();
        }
        while (!buffer.isFull())
        {
            double lastR = r;
            r = Math.random() - 0.5;
            if (lastR != r)
            {
                buffer.enqueue(r);
            }
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double first = buffer.dequeue();
        double second = buffer.peek();
        double newFirst = ((first + second) / 2) * DECAY;
        buffer.enqueue(newFirst);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        if (!buffer.isEmpty())
        {
            return buffer.peek();
        }
        return 0;
    }
}
