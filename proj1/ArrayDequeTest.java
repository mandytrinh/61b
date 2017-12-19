public class ArrayDequeTest
{
	public static void main(String[] args)
	{
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		resizeTest;
	}
	
	public static void printTestStatus(boolean passed)
	{
		if (passed)
		{
			System.out.println("Hooray! Test passed!\n");
		}
		else
		{
			System.out.println("Test failed\n");
		}
	}
	// checks isEmpty()
	public static boolean checkEmpty(boolean expected, boolean actual)
	{
		if (expected != actual)
		{
			System.out.println("isEmpty() expected" + expected + ", but returned" + actual);
			return false;
		}
		return true;
	}
	
	//checks size()
	public static boolean checkSize(int expected, int actual)
	{
		if (expected != actual)
		{
			System.out.println("size() expected" + expected + ", but returned" + actual);
			return false;
		}
		return true;
	}
	
	
}