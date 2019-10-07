
// SEMINAR code created and submitted by spw00004

public class Seminar extends Lecture
{
	public Seminar(String whichClass, String name ,String day, String startTime, String endTime, String weekPattern, String location,
			int roomSize, int classSize, String staff, String department, String whichNumber, String ID) 
	{
		super(whichClass, name, day, startTime, endTime, weekPattern, location, roomSize, classSize, staff, department, whichNumber, ID);
	}
	public String getDetails()
	{
		String myClass = classSuitablity();
		
		return("Seminar " + getID().toLowerCase() +  ":"  + getWhichNumber() + " for " + getName().toLowerCase() + " is on " + getDay().toLowerCase() + " from " 
	+ getStartTime().toLowerCase() + " to " + getEndTime().toLowerCase() + " it runs weeks " + getWeekPattern().toLowerCase()
		+ " at " + getLocation().toLowerCase() + " room size: " + getRoomSize() + " class size: " 
	+ getClassSize() + " taught by " + getStaff().toLowerCase() + " from " + getDepartment()).toLowerCase() + myClass + "\n";
	} 

	public String classSuitablity()
	{
		if(getClassSize() < getRoomSize())
				if(isClassTooBig())
					return (" ~ room is too big!"); //room too big
				else
					return("");
		else
			if(isClassTooSmall())
				return(" room is too small!"); //room too small
			else
				return("");
	}
	public boolean isClassTooBig()
	{
		if(getClassSize() < getRoomSize()/2) //check if class is too big for students
			return true;
		else
			return false;
	}
	public boolean isClassTooSmall()
	{
		if(getClassSize() > getRoomSize()*1.1) //check if class is too small for students
			return true;
		else
			return false;
	}
}
