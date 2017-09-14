public class Planet
{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;

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
    //second constructor: should take in a Planet object and initialize an identical Planet object
    public Planet(Planet p) //p can be replaced with any name for Planet object
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

    }
	public double calcDistance(Planet other)
	{ 
    /*This method will take in a single Planet and should return a double equal to the distance between the supplied planet and the planet that is doing the calculation
    */
		double distance; //r = distance
		double rSquared;
		double dxSquared;
		double dySquared;
		dxSquared = (this.xxPos - other.xxPos) * (this.xxPos - other.xxPos);
		dySquared = (this.yyPos - other.yyPos) * (this.yyPos - other.yyPos);
		rSquared = dxSquared + dySquared;
		distance = Math.sqrt(rSquared);
		return distance;
	}
    
    public double calcForceExertedBy(Planet exertingPlanet)
    {
    /* This method takes in a planet (what's doing the exertion) and returns a double describing the force exerted on this planet by the given planet. Call the calcDistance method here. */
    double graviationalConstant =  0.0000000000667;
    double mass1 = this.mass;
    double mass2 = exertingPlanet.mass;
    double distance = calcDistance(exertingPlanet);
    double distanceSquared = distance * distance;
    double force;
    force = (graviationalConstant * mass1 * mass2) / distanceSquared;
    return force;
    
    }
    
}