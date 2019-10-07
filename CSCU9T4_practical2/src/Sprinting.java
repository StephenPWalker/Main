
public class Sprinting extends Entry
{
	private int recoveryMins;
	private int howManyRuns;
	
	public Sprinting (String n, int d, int m, int y, int h, int min, int s, float dist, int recoveryMins, int howManyRuns) 
	{
	    super(n,d,m,y,h,min,s,dist);
	    this.recoveryMins = recoveryMins;
	    this.howManyRuns = howManyRuns;
	} //constructor
	
	public int getRecoveryMins()
	{
		return recoveryMins;
	}
	public int getHowManyRuns()
	{
		return howManyRuns;
	}
	
	  public String getEntry ()
	  {
		   String result = getName()+" sprinted " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " " + getHowManyRuns() + " times with " + getRecoveryMins()
		             + " mins rest.\n";
		   return result;
	  } //getEntry
}
