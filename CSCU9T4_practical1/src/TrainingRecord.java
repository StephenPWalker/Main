// An implementation of a Training Record as an ArrayList

import java.util.*;
public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public boolean addEntry(Entry e)
   {
	   boolean hasEntry = false;
	   ListIterator<Entry> iter = tr.listIterator();
	   while (iter.hasNext()) 
       {
		   Entry current = iter.next();
		   if(current.getName().equals(e.getName()) && current.getDay()==e.getDay() && current.getMonth()==e.getMonth() && current.getYear()==e.getYear())
		   {			   
			   hasEntry = true;
			   return hasEntry;
		   }
       }
	   if(hasEntry == false)
	   {
		   tr.add(e);
	   }
	   return hasEntry;
   }
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) 
   {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) 
       {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
       }
       return result;
   } // lookupEntry
   public String findAllDates (int d, int m, int y) 
   {
       ListIterator<Entry> iter = tr.listIterator();
       int count = 0;
       String result = "";
       while (iter.hasNext()) 
       {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
          {
        	 count ++;
             result += current.getEntry();     
          }
       }
       if(count == 0)
    	   result = "No entries found";
       return result;
   } // findAllDates
} // TrainingRecord