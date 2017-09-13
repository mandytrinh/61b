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
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

    }
	public double calcDistance(Planet other)
	{
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

}