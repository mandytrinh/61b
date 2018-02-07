import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B
{

    @Test
    public void addRemoveTestFirst()
    {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        for (int i = 0; i < 4; i++)
        {
            sad1.addFirst(i);
        }
        for (int k = 0; k < 2; k++)
        {
            sad1.removeFirst();
        }
        int first = sad1.removeFirst();
        assertEquals(1, first);
        int last = sad1.removeLast();
        assertEquals(0, last);
    }

    @Test
    public void addRemoveLastTest()
    {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        for (int i = 0; i < 4; i++)
        {
            sad1.addLast(i);
        }
        for (int j = 0; j < 2; j++)
        {
            sad1.removeLast();
        }
        int first = sad1.removeFirst();
        assertEquals(0, first);
        int last = sad1.removeLast();
        assertEquals(1, last);
    }

    @Test
    public void sizeTest()
    {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        assertEquals(0, sad1.size());
        FailureSequence fs = new FailureSequence();

        for (int i = 0; i < 15; i++)
        {
            sad1.addFirst(i);
            DequeOperation do1 = new DequeOperation("addFirst", i);
            fs.addOperation(do1);
        }
        assertEquals(15, sad1.size());

        for (int y = 0; y < 17; y++)
        {
            sad1.removeFirst();
            DequeOperation do2 = new DequeOperation("removeFirst", y);
            fs.addOperation(do2);
        }
        assertEquals(0, sad1.size()); //Error here, can go into negatives
        assertTrue(sad1.isEmpty());

    }
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
    }
}