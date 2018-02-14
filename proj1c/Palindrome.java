public class Palindrome
{
    public static Deque<Character> wordToDeque(String word)
    {
        /* builds a Deque where the characters in the deque
        appear in the same order as in the word.*/
        Deque<Character> characterDeque = new LinkedListDequeSolution<Character>();
        for (int i = 0; i < word.length(); i++)
        {
            char character = word.charAt(i);
            characterDeque.addLast(character);
        }
        //System.out.print(characterDeque);
        return characterDeque;
    }
    private static boolean isPalindromeRecursiveHelper (Deque<Character> word)
    {
        if (word.size() == 0 || word.size() == 1)
        {
            return true;
        }
        else
        {
            char characFromLast = word.removeLast();
            char characFromFirst = word.removeFirst();
            if (characFromFirst == characFromLast)
            {
                return isPalindromeRecursiveHelper(word);
            }
        }
        return false;
    }
    public static boolean isPalindrome(String word)
    {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindromeRecursiveHelper(characterDeque);
    }
}
