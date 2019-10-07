package practical2;

import java.util.Random;import java.io.*;
public class gate 
{
	byte t[] = { 0 };
	RandomAccessFile admin;
	int internal_count;
	int count;
	String me;
	boolean isActive = false;
	public gate(String g)
	{
		try 
		{
			admin = new RandomAccessFile("admin.txt", "rw");
		} 
		catch (IOException e) 
		{
			
		}
			internal_count = 0;
			count = 0;
			me = g;
		}
	
	public void counting() 
	{
		int i;		
		for (i = 0; i < 50; i++) 
		{
			try 
			{
				if(isActive == false)
				{
					isActive = true;
					admin.seek(0);
					admin.read(t);
					count = t[0];
					Thread.sleep(0);
					count = count + 1;
					internal_count++;
					t[0] = (byte) count;
					admin.seek(0);
					admin.write(t);
					Thread.sleep(100);
					isActive = false;
				}
			} 
			catch (Exception e) 
			{
				
			}
			System.out.println(me + ": Shared Counter: " + count + " internalcounter: " + internal_count);
		}
	}
}