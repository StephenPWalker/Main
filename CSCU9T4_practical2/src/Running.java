
public class Running extends Entry
{
	private String terrain;
	
	public Running (String n, int d, int m, int y, int h, int min, int s, float dist, String terrain) 
	{
	    super(n,d,m,y,h,min,s,dist);
	    this.terrain = terrain;
	} //constructor
	
	public String getTerrain()
	{
		return terrain;
	}	
	  public String getEntry ()
	  {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " on " + getTerrain() + " terrain\n";
		   return result;
	  } //getEntry
}
