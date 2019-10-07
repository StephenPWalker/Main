// LECTURE code created and submitted by spw00004

public class Lecture extends Entry
{
	private String whichClass, name, day, startTime, endTime, weekPattern, location, staff, department, whichNumber, ID;
	private int roomSize, classSize;
	public Lecture(String whichClass, String name ,String day, String startTime, String endTime, String weekPattern, String location,
			int roomSize, int classSize, String staff, String department, String whichNumber, String ID) 
	{
		this.whichClass = whichClass;
		this.name = name;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekPattern = weekPattern;
		this.location = location;
		this.roomSize = roomSize; 
		this.classSize = classSize;
		this.staff = staff;
		this.department = department;
		this.whichNumber = whichNumber;
		this.ID = ID;
	}
	public String getWhichClass()
	{
		return whichClass;
	}
	public String getName()
	{
		return name;
	}
	public String getDay()
	{
		return day;
	}
	public String getStartTime()
	{
		return startTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public String getWeekPattern()
	{
		return weekPattern;
	}
	public String getLocation()
	{
		return location;
	}
	public String getStaff()
	{
		return staff;
	}
	public String getDepartment()
	{
		return department;
	}
	public int getRoomSize()
	{
		return roomSize;
	}
	public int getClassSize()
	{
		return classSize;
	}
	public String getWhichNumber()
	{
			return whichNumber;
	}
	public String getID()
	{
			return ID;
	}
	//add details to all methods defined in abstract class entry
	public String getDetails()
	{
		return("Lecture " + getID().toUpperCase() +  ":" + getWhichNumber() + " for " + getName().toUpperCase() + " is on " + getDay().toUpperCase() + " from "
	+ getStartTime().toUpperCase() + " to " + getEndTime().toUpperCase() + " it runs weeks " + getWeekPattern().toUpperCase()
		+ " at " + getLocation().toUpperCase() + " room size: " + getRoomSize() + " class size: "
	+ getClassSize() + " taught by " + getStaff().toUpperCase() + " from " + getDepartment()).toUpperCase() + "\n";
	} 
}
