public class maxNum
{ 
  public static void main(String[] args) 
  { 
    int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
    int maxNumber = getMax(numbers);
    System.out.print(maxNumber);
  }
  
  public static int getMax(int[] array)
  {
    int curMax = 0;
    int length = array.length;
    int i = 0;
    while(i < length)
    {
        if (array[i] > curMax)
        {
            curMax = array[i];
        }
        i = i + 1;
        
    }
    return curMax;
   
  }  
}

