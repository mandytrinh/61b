/* This cl
ass will have NO constructor. 
    The goal of this class is to simulate a universe specified in one of the data files */
    
import java.util.Scanner;

public class NBody
{
    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        double radius = readRadius(filename);
        Planet[] planetsArray = readPlanets(filename); 
        StdDraw.setScale(-radius, radius);
        String bgImage = "./images/starfield.jpg";
        double xCord = 0;
        double yCord = 0;       
        double currentTime = 0;
        // new arrays for X & Y forces with size as #s of planets
        double[] xForces = new double[numOfPlanets]; 
        double[] yForces = new double[numOfPlanets];
        while (currentTime < T)
        {
            int i = 0;
            for (Planet currentPlanet: planetsArray)
            {
                xForces[i] = currentPlanet.calcNetForceExertedByX(planetsArray);
                yForces[i] = currentPlanet.calcNetForceExertedByY(planetsArray);
                i = i + 1;               
            }
            //reset i back to 0 to loop thru planetsArray again in UPDATE method
            i = 0; 
            StdDraw.picture(xCord, yCord, bgImage);
            for (Planet currentPlanet:planetsArray)
                {                    
                    currentPlanet.update(dt, xForces[i], yForces[i]);currentPlanet.draw();
                    i = i + 1;                   
                }
            StdDraw.show(10);
            currentTime = currentTime + dt;
        }
        
        StdOut.printf("%d\n", planetsArray.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planetsArray.length; i++) 
        {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planetsArray[i].xxPos, planetsArray[i].yyPos, planetsArray[i].xxVel, planetsArray[i].yyVel, planetsArray[i].mass, planetsArray[i].imgFileName);	
        }	
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