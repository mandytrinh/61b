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
        //sad1.printDeque();
        int first = sad1.removeFirst();
        assertEquals(1, first);
        int last = sad1.removeLast();
        assertEquals(0, last);
        assertEquals(0,sad1.size());
        sad1.removeLast();
        assertEquals(0, sad1.size()); //failure; getting negative instead of 0
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
        //sad1.printDeque();
        int first = sad1.removeFirst();
        assertEquals(0, first);
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
        //sad1.printDeque();
        int expected = 0;
        int actual = sad1.size();
        assertEquals("Expected " + expected + " but got " + actual, expected, actual); //Error here, can go into negatives
        assertTrue(sad1.isEmpty());

    }
    @Test
    public void getTest()
    {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        for (int i = 0; i < 4; i++)
        {
            sad1.addFirst(i);
        }
        //sad1.printDeque();
        int x = 0;
        int actual = sad1.get(x);
        assertEquals(3, actual);
    }


    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDeque1B.class);
    }
}