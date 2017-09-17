public class Planet
{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;
    public double netAcceleration_X;
    public double netAcceleration_Y;
    public double xNewVelocity;
    public double yNewVelocity; 
    public double xNewPos;
    public double yNewPos;

    //first constructor
    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName)
    {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }
    /* second constructor: should take in a Planet object and 
    initialize an identical Planet object */
    public Planet(Planet p) //p can be replaced with any name for Planet object
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    
	public double calcDistance(Planet exertingPlanet)
	{ 
    /* This method will take in a single Planet and should return a double equal 
    to the distance between the supplied planet and the planet that is doing the calculation
    */
		double distance; //r = distance
		double rSquared;
		double dxSquared;
		double dySquared;
		dxSquared = (exertingPlanet.xxPos - this.xxPos) * (exertingPlanet.xxPos - this.xxPos);
		dySquared = (exertingPlanet.yyPos - this.yyPos) * (exertingPlanet.yyPos - this.yyPos);
		rSquared = dxSquared + dySquared;
		distance = Math.sqrt(rSquared);
		return distance;
	}
    
    public double calcForceExertedBy(Planet exertingPlanet)
    {
    /* Pairwise force: This method takes in a planet (what's doing the exertion) 
    and returns a double describing the force exerted on this planet by the given planet.
    Call the calcDistance method here. */
    double graviationalConstant =  0.0000000000667;
    double mass1 = this.mass;
    double mass2 = exertingPlanet.mass;
    double distance = calcDistance(exertingPlanet);
    double distanceSquared = distance * distance;
    double force;
    force = (graviationalConstant * mass1 * mass2) / distanceSquared;
    return force;    
    }
    
    public double calcForceExertedByX(Planet exertingPlanet)
    { // describes the force exerted in the X direction
        double force = calcForceExertedBy(exertingPlanet);
        double distance = calcDistance(exertingPlanet);
        double dx = exertingPlanet.xxPos - this.xxPos;
        double force_X;
        force_X = (force * dx) / distance;
        return force_X;        
    }
    public double calcForceExertedByY(Planet exertingPlanet)
    { // describes the force exerted in the Y direction
        double force = calcForceExertedBy(exertingPlanet);
        double distance = calcDistance(exertingPlanet);
        double dy = exertingPlanet.yyPos - this.yyPos;
        double force_Y;
        force_Y = (force * dy) / distance;
        return force_Y;
    }
    
    public double calcNetForceExertedByX(Planet[] allExertingPlanets)
    { 
    /* NET X FORCE: This method takes in an array of Planets and calculates the net X force 
    exerted by all planets in that array upon the current Planet */
        double force_X = 0;
        double netX = 0;
        for (Planet currentPlanet : allExertingPlanets)
        {
            if (!this.equals(currentPlanet))
            {
                force_X = calcForceExertedByX(currentPlanet);
                netX = netX + force_X; 
            }
        }
        return netX; 
    }   
    
    public double calcNetForceExertedByY(Planet[] allExertingPlanets)
    { 
    /* NET Y FORCE: This method takes in an array of Planets and calculates the net Y force 
    exerted by all planets in that array upon the current Planet */
        double force_Y = 0;
        double netY = 0;
        for (Planet currentPlanet : allExertingPlanets)
        {
            if (!this.equals(currentPlanet))
            {
                force_Y = calcForceExertedByY(currentPlanet);
                netY = netY + force_Y; 
            }
        }
        return netY; 
    }

    public void update(double dt, double netX, double netY)
    {
    /* determines how much the forces exerted on the planet will cause that planet to accelerate,
    & the resulting change in the planet's velocity and position in a small period of time dt. 
    I.e this updates the planet's position and velocity instance variables */
        
        // 1) Calculate the acceleration using the provided x and y forces 
        this.netAcceleration_X = netX/this.mass;
        this.netAcceleration_Y = netY/this.mass;
        
        /* 2) Calculate the new velocity by using the acceleration and current velocity. 
        Recall that accleration describes the change in velocity per unit time, 
        so the new velocity is (vx + dt * ax, vy + dt * ay) */
        this.xxVel = this.xxVel + dt * this.netAcceleration_X;
        this.yyVel = this.yyVel + dt * this.netAcceleration_Y;
        
        /* 3) Calculate the new position by using the velocity computed in step 2 
        and the current position. The new position is (px + dt * vx, py + dt * vy) */
        this.xxPos = this.xxPos + dt * this.xNewVelocity;
        this.yyPos = this.yyPos + dt * this.yNewVelocity;
        
    }
    
}