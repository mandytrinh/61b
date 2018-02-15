import static org.junit.Assert.*;
import org.junit.Test;

public class TestPalindrome
{
    @Test
    public void zeroStringTest()
    {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    public void singleStringTest()
    {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void twoStringTest()
    {
        assertTrue(Palindrome.isPalindrome("aa"));

    }

    @Test
    public void negativeTwoStringTest()
    {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    @Test
    public void wordTest()
    {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }

    @Test
    public void negativeWordTest()
    {
        assertFalse(Palindrome.isPalindrome("slartibartfast"));
    }

    @Test
    public void fullSentenceNotCaseSensitive()
    {
        assertTrue(Palindrome.isPalindrome("AManAPlanACanalPanama"));
    }

    @Test
    public void longNonsenseString()
    {
        assertTrue(Palindrome.isPalindrome("AAAAAAAaaaaaaaaaaaaaAAAAAAAAAAAAAAAAAAaaAAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
