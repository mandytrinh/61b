public class Palindrome
{
    public static Deque<Character> wordToDeque(String word)
    {
        Deque<Character> characterDeque = new LinkedListDequeSolution<Character>();
        for (int i = 0; i < word.length(); i++)
        {
            char character = word.charAt(i);
            characterDeque.addLast(character);
        }
        return characterDeque;
    }
    public static boolean isPalindrome(String word)
    {

    }
}
