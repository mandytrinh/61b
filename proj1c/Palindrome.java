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
        //helper method for isPalindrome below

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
        // should return true if the given word is a palindrome, and false otherwise
        word = word.toUpperCase(); //to eliminate case sensitivity
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindromeRecursiveHelper(characterDeque);
    }

    private static boolean isPalindromeRecursiveHelper(Deque<Character> word, CharacterComparator cc)
    {
        if (word.size() == 0 || word.size() == 1)
        {
            return true;
        }
        else
        {
            char characFromFirst = word.removeFirst();
            char characFromLast = word.removeLast();
            if (cc.equalChars(characFromFirst, characFromLast))
            {
                isPalindromeRecursiveHelper(word, cc);
            }
        }
        return false;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc)
    {
        word = word.toUpperCase();
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindromeRecursiveHelper(characterDeque, cc);
    }
}
