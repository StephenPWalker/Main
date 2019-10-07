import java.util.Vector;
public class my_queue
{
	Vector<Integer> queue = new Vector<Integer>(); 
	int internal_count;
	int count;
	
	public my_queue()
	{
		internal_count = 0;
		count = 0;
	}
	public synchronized void tgEnter() throws InterruptedException
	{	
		if(count < 100)
		{
			queue.add(count);
			count += 1;
			internal_count += 1;
			System.out.println("Top gate 1 entered, Total : " + count + " , Internal total : " + internal_count);				
			Thread.sleep(400);	
			notifyAll();
		}
	}
	public synchronized void bgEnter() throws InterruptedException
	{		
		if(count < 100)
		{
			queue.add(count);
			count += 1;
			internal_count += 1;
			System.out.println("Bottom gate entered, Total : " + count + " , Internal total : " + internal_count);				
			Thread.sleep(500);	
			notifyAll();	
		}
	}
}
