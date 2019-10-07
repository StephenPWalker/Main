// COMPUTERLAB code created and submitted by spw00004

public class ComputerLab extends Lecture 
{
	public ComputerLab(String whichClass, String name ,String day, String startTime, String endTime, String weekPattern, String location,
			int roomSize, int classSize, String staff, String department, String whichNumber, String ID) 
	{
		super(whichClass, name, day, startTime, endTime, weekPattern, location, roomSize, classSize, staff, department, whichNumber, ID);
	}
	public String getDetails()
	{
		String myClass = classSuitablity();
		return("Computer lab " + getID().toLowerCase() + ":" + getWhichNumber() + " for " + getName().toLowerCase() + " is on " + getDay().toLowerCase() + " from "
	+ getStartTime().toLowerCase() + " to " + getEndTime().toLowerCase() + " it runs weeks " + getWeekPattern().toLowerCase()
		+ " at " + getLocation().toLowerCase() + " room size: " + getRoomSize() + " class size: "
	+ getClassSize() + " taught by " + getStaff().toLowerCase() + " from " + getDepartment()).toLowerCase() + myClass + "\n";
	} 
	public boolean isClassTooBig()
	{
		if(getClassSize() > getRoomSize()) //check class size vs room size
				return true;
		else
			return false;
	}
	public String classSuitablity()
	{
		if(isClassTooBig())
			return (" ~ room is too small!"); // check if the room size is too small
		else
			return("");
	}
}
