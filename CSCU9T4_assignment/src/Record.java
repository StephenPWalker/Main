// RECORD code created and submitted by spw00004

import java.util.*;

public class Record 
{
	private List<Lecture> re;
	int count;
	
	public Record() 
    {
        re = new ArrayList<Lecture>();
    } //constructor
	public boolean addEntry(Lecture e)
	{
	   boolean hasEntry = false;
	   ListIterator<Lecture> iter = re.listIterator();
	   while (iter.hasNext()) 
       {
		   Lecture current = iter.next();
		   if (current.getName().toUpperCase().equals(e.getName().toUpperCase()) && current.getWhichClass().substring(0, 1).equals(e.getWhichClass().substring(0, 1)) 
    				&& current.getDay().toUpperCase().equals(e.getDay().toUpperCase()) && current.getWeekPattern().equals(e.getWeekPattern())
    				&& current.getStartTime().equals(e.getStartTime()) && current.getEndTime().equals(e.getEndTime())
    				&& current.getWhichNumber().equals(e.getWhichNumber()) && current.getID().toUpperCase().equals(e.getID().toUpperCase()))
		   {			   
			   hasEntry = true; //if all the details are the same entry already exists
			   return hasEntry;
		   }	   
       }
	   if(hasEntry == false)
	   {
		   re.add(e); //if not add the entry
		   count ++;
	   }
	   return hasEntry;
	}
	public boolean removeEntry(Lecture e)
	{
	   boolean hasEntry = false;
	   ListIterator<Lecture> iter = re.listIterator();
	   while (iter.hasNext()) 
       {
		   Lecture current = iter.next();
		   if (current.getName().toUpperCase().equals(e.getName().toUpperCase()) && current.getWhichClass().substring(0, 1).equals(e.getWhichClass().substring(0, 1)) 
   				&& current.getDay().toUpperCase().equals(e.getDay().toUpperCase()) && current.getWeekPattern().equals(e.getWeekPattern())
   				&& current.getStartTime().equals(e.getStartTime()) && current.getEndTime().equals(e.getEndTime())
   				&& current.getWhichNumber().equals(e.getWhichNumber()) && current.getID().toUpperCase().equals(e.getID().toUpperCase()))
		   {			   
			   hasEntry = true; //if all the details are the same entry already exists
			   re.remove(current); //remove entry
			   count--;
			   break;
		   }	   
       }
	   return hasEntry;
	}
	
	public void removeAll()
	{
		re.clear();
		setCount();
	}
	
	public String findByName(String name, String classType, String number, String id)
	{
		String nameUC = name.toUpperCase();
		ListIterator<Lecture> iter = re.listIterator();
		String result = "";
		int count = 0;
       	while (iter.hasNext()) 
       	{
       		Entry current = iter.next();
       		if ((current.getName().equals(name) || current.getName().equals(nameUC)) && classType.equals(current.getWhichClass().substring(0, 1))
       				&& current.getWhichNumber().equals(number) && current.getID().equals(id)) 
       		{
       			count++;
       			result += current.getDetails(); //check all variations of the name for an exact match output all matches  
       		}
       	}
       	if(count > 0)
       		return result;
       	else
       		return("No entries found, bare in mind if the class has a number or id it is also required for this search.\n");
	}
	public String findPartial(String name, String classType)
	{
		String nameUC = name.toUpperCase();
		ListIterator<Lecture> iter = re.listIterator();
		String result = "";
		int counter = 0;
       	while (iter.hasNext()) 
       	{
       		Entry current = iter.next();
       		if ((current.getName().contains(name) || current.getName().contains(nameUC)) && classType.equals(current.getWhichClass().substring(0, 1))) 
       		{
       			counter++;
       			result += current.getDetails(); //check all variations of the name for an exact match output all matches  
       		}
       	}
       	if(counter > 0)
       		return result;
       	else
       		return("No entries found\n");
	}
	public String findExact(String name, String classType, String day, String startTime, String endTime, String weekPattern, String number, String id)
	{
		name = name.toUpperCase();
		classType = classType.toUpperCase();
		day = day.toUpperCase();
		id = id.toUpperCase();
		ListIterator<Lecture> iter = re.listIterator();
		String result = "";
		int counter = 0;
       	while (iter.hasNext()) 
       	{
       		Entry current = iter.next();
       		if (current.getName().toUpperCase().equals(name) && classType.equals(current.getWhichClass().substring(0, 1)) 
       				&& current.getDay().toUpperCase().equals(day) && current.getWeekPattern().equals(weekPattern)
       				&& current.getStartTime().equals(startTime) && current.getEndTime().equals(endTime)
       				&& current.getWhichNumber().equals(number) && current.getID().toUpperCase().equals(id))
       		{
       			counter++;
       			result += current.getDetails(); //check all variations of the name for an exact match output all matches  
       		}
       	}
       	if(counter > 0)
       		return result;
       	else
       		return("No entries found, bare in mind all information for name, day, week pattern, start time, end time, id and number must be exact.\n");
	}
	public int getCount()
	{
		return count;
	}
	public void setCount()
	{
		count = 0;
	}
}
