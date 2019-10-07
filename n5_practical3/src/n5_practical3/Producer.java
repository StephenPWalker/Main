package n5_practical3;
public class Producer extends Thread
{
	MyQueue mq;
	//private Object value = new Object();
	
	
	public Producer(MyQueue m)
	{
		mq=m;
	}
	public void run()
	{
		try 
		{
			while(true)
			{
				mq.Produce();
				Thread.sleep(500);	
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
}
