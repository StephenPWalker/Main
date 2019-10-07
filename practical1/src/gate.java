import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class gate 
{

	String gate;
	RandomAccessFile admin;
	int value = 0;
	
	public gate(String whichGate)
	{		
		gate = whichGate;
	}
	
	public void counting()
	{	
		for(int i = 1; i <= 50; i++)
		{	
			try 
			{
				admin = new RandomAccessFile("admin.txt","rw");
				try 
				{
					admin.seek(0);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			try 
			{								
				value = admin.read();
				try 
		        {
					if(gate.equals("gate_top"))
						Thread.sleep(250);
					else
						Thread.sleep(500);
				} 
		        catch (InterruptedException e) 
		        {
					e.printStackTrace();
				}
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}			
			try 
			{	
				value += 1;
				admin.seek(0);
				admin.write(value);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
			System.out.println("Increments: " + i + " Value: " + value);	
		}
	}
}