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
				mq.Produce(1);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
}
