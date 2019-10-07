
public class Swimming extends Entry
{	
	private boolean isIndoors;
	public Swimming (String n, int d, int m, int y, int h, int min, int s, float dist, boolean isIndoors) 
	{
	    super(n, d, m, y, h, min, s, dist);
	    this.isIndoors = isIndoors;
	} //constructor
	
	 public boolean getIsIndoors () 
	 {
		    return isIndoors;
	 } //getName
	 
	 public String getWasItIndoors()
	 {
		 String inOut = (" "); 
		 if(getIsIndoors())
		 {
			 inOut = "inside";
		 }
		 else
		 {
			 inOut = "outside";
		 }
		 return inOut;
	 }
	  public String getEntry ()
	  {
		   String result = getName()+" swam " + getDistance() + " km " + getWasItIndoors() + " in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " \n";
		   return result;
	  } //getEntry
}
