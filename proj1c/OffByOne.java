public class OffByOne implements CharacterComparator
{
    @Override
    public boolean equalChars(char x, char y)
    {
        // returns true for letters that are different by one letter

        int diff = x - y;
        return (diff == 1 || diff == -1);
    }

}
