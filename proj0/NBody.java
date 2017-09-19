/* This class will have NO constructor. 
    The goal of this class is to simulate a universe specified in one of the data files */
    
import java.util.Scanner;
public class NBody
{
    //public static void main(String[] args)

    public static double readRadius(String fileName)
    { /*  Given a file name, it should return a double corresponding to the radius of the universe in that file 
    
    Note - This is a CLASS method (static)
    It is not invoked on an instant but on the class itself */
    
        In in = new In(fileName);
        int numOfPlanets = 0;
        double radius = 0;        
        while (!in.isEmpty())
        {
            numOfPlanets = in.readInt();
            radius = in.readDouble();
            break;
        }
        return radius;        
    }
}