import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedListDeque1B
{
    @Test
    public void emptyTest()
    {
        StudentLinkedListDeque<Integer> sll1 = new StudentLinkedListDeque<Integer>();
        int actual = sll1.size();
        assertEquals(0, actual);
    }
    @Test
    public void addRemoveTest()
    {
        StudentLinkedListDeque<Integer> sll1 = new StudentLinkedListDeque<Integer>();
        for (int i = 0; i < 4; i ++)
        {
            sll1.addFirst(i);
        }
        //sll1.printDeque();
        int first = sll1.removeFirst();
        assertEquals(3, first);
        assertEquals(3, sll1.size());
        for (int k = 0; k < 3; k++)
        {
            sll1.removeLast();
        }
        sll1.printDeque();
        assertEquals(0, sll1.size());
    }
    @Test
    public void getTest()
    {
        FailureSequence fs = new FailureSequence();
        StudentLinkedListDeque<Integer> sll1 = new StudentLinkedListDeque<Integer>();
        for (int i = 0; i < 5; i++)
        {
            sll1.addFirst(i);
            DequeOperation do1 = new DequeOperation("addFirst", i);
            fs.addOperation(do1);
        }
        int firstItem = sll1.get(0);
        assertEquals(4, firstItem);
        int lastItem = sll1.get(4);
        assertEquals(0, lastItem);

        int itemOutsideIndex = sll1.get(7);
        DequeOperation do2 = new DequeOperation("get");
        fs.addOperation(do2);
        assertEquals(fs.toString(), null, itemOutsideIndex); //fails here, item out of bound, should return null but gives a number
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestLinkedListDeque1B.class);
    }

}
