public class ArrayDequeTest
{
	public static void main(String[] args)
	{
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		resizeTest();
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
	
	//Adds an item, then removes it, make sure array deque (ad) is empty afterwards
	public static void addRemoveTest()
	{
		System.out.println("Now running add, remove test.");
		
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		//first time, should be empty
		boolean passed = checkEmpty(true, ad.isEmpty());
		
		ad.addFirst(10);
		//adding something to the front; should NOT be empty
		passed = checkEmpty(false, ad.isEmpty()) && passed;
		
		ad.removeFirst();
		//removing that 10 we just added; should now be empty again
		passed = checkEmpty(true, ad.isEmpty()) && passed;
		
		printTestStatus(passed);
		
	}
	
	public static void resizeTest()
	{
		System.out.println("Now running resize test");
		
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		//first time, should be empty with capacity as 8
		boolean passed = checkEmpty(true, ad.isEmpty());
		passed = checkSize(8, ad.getCapacity()) && passed;
	
		// adds 1 to array deque until 10
		for (int i =0; i < 10; i++)
		{
			ad.addLast(i);
		}
		
		// now size should be 10 (original 0 + 10), and capacity should be 16 (original capacity * 2 for every new 8 items added)
		passed = checkSize(10, ad.size()) && passed;
		passed = checkSize(16, ad.getCapacity()) && passed;
		
		// adds 1 to array deque until 30
		for (int i = 0; i < 30; i++)
		{
			ad.addLast(i);
		}
		
		//now size should be 40 (10 + 30), and capacity should be 64 (16 doubled twice)
		passed = checkSize(40, ad.size()) && passed;
		passed = checkSize(64, ad.getCapacity()) && passed;
		
		// removes 25 from array deque; size should be 15, usage factor is now 15/64 = 0.23, so half the arraydeque
		for (int i = 0; i < 25; i++)
		{
			ad.removeLast();
		}
		
		passed = checkSize(15, ad.size()) && passed;
		passed = checkSize(32, ad.getCapacity()) && passed;
		
		printTestStatus(passed);
	}
}





