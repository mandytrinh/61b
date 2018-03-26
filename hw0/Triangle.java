/*
public class Triangle 
{ public static void main(String[] args) 
  { int size = 5;
    int row = 0;
    while (row <= size) 
    { 
      int col = 0;
      while (col < row)
      { 
        System.out.print('*');
        col = col + 1;
      }
      System.out.println();
      row = row + 1;
    }
  }   
}
*/

public class Triangle
{
    public static void main (String[] args)
    {
        int counter = 0;
        String triangle = "*";
        while (counter < 5)
        {
            System.out.print(triangle);
            System.out.println();
            triangle += '*';
            counter +=1;
        }
    }
}
