public class OffByN implements CharacterComparator
{
    //constructor OffByN
    int N;

    public OffByN(int N)
    {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y)
    {
        //  returns an object whose equalChars method returns true for characters that are off by N
        int diff = x - y;
        return diff == N || diff == -N;
    }

}
