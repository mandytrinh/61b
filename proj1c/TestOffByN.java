import static org.junit.Assert.*;
import org.junit.Test;


public class TestOffByN
{
    @Test
    public void positiveOffBy5Test()
    {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));
    }

    @Test
    public void positiveOffBy7FlippedTest()
    {
        OffByN offBy7 = new OffByN(7);
        assertTrue(offBy7.equalChars('s', 'l'));
    }

    @Test
    public void negativeOffByNTest()
    {
        OffByN offBy3 = new OffByN(3);
        assertFalse(offBy3.equalChars('z', 'k'));
    }
}
