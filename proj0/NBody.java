/* This class will have NO constructor. 
    The goal of this class is to simulate a universe specified in one of the data files */
    
import java.util.Scanner;

public class NBody
{
    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planetsArray = readPlanets(filename); 
        StdDraw.setScale(-radius, radius);
        String imageToDraw = "./images/starfield.jpg";
        double xCord = 0;
        double yCord = 0;
        //Draws the specified image centered at (x, y)
        StdDraw.picture(xCord, yCord, imageToDraw);
    }
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
    
    public static Planet[] readPlanets(String fileName)
    { /* Given a file name, it should return an array of Planets corresponding to the planets in the file */
    
        In in = new In(fileName);
        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] planetsArray = new Planet[numOfPlanets];      
        double xVel = 0;
        double yVel = 0;
        double xPos = 0;
        double yPos = 0;
        double mass = 0;
        String planetName = "";
        int i = 0;
        while (i < numOfPlanets)
        {
            xPos = in.readDouble();
            yPos = in.readDouble();
            xVel = in.readDouble();
            yVel = in.readDouble();
            mass = in.readDouble();
            planetName = in.readString();            
            Planet p = new Planet(xPos, yPos, xVel, yVel, mass, planetName);
            planetsArray[i] = p; //add planet to array
            i = i + 1;
        }
        return planetsArray;       
    }
}