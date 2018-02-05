import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B
{
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
    }
}