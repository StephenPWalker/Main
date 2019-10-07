
public class Cycling extends Entry
{
	private String terrain;
	private int tempo;
	
	public Cycling (String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, int tempo) 
	{
	    super(n,d,m,y,h,min,s,dist);
	    this.terrain = terrain;
	    this.tempo = tempo;

	} //constructor
	
	public String getTerrain()
	{
		return terrain;
	}	
	public int getTempo()
	{
		return tempo;
	}
	 public String getEntry ()
	  {
		   String result = getName()+" cycled " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " on " + getTerrain() + " terrain at a tempo of " 
		             +getTempo() + " km/h\n";
		   return result;
	  } //getEntry
}
