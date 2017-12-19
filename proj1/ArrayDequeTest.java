public class ArrayDequeTest
{
	public static void main(String[] args)
	{
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		resizeTest;
	}
	// prints a message on whether the test failed or passed
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
	
	// checks add by adding a few things to the list, checking isEmpty() & size() are correct, prints the result
	
	public static void addIsEmptySizeTest()
	{
		System.out.println("Now running add, isEmpty, & size test.");
		ArrayDeque<String> ad = new ArrayDeque<String>();
		boolean passed = checkEmpty(true, ad.isEmpty());
		
		ad.addFirst("front");
		passed = checkSize(1, ad.size()) && passed;
		passed = checkEmpty(false, ad.isEmpty()) && passed;
		
		ad.addLast("middle");
		passed = checkSize(2, ad.size()) && passed;
		
		ad.addLast("back");
		passed = checkSize(3, ad.size()) && passed;
		
		System.out.println("Printing out array deque:");
		ad.printDeque();
		
		printTestStatus(passed);
	}
	
}





