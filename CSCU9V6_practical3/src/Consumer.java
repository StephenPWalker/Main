public class Consumer extends Thread
{
	MyQueue mq;
	
	public Consumer(MyQueue m)
	{
		mq=m;
	}
	public void run()
	{
		try 
		{
			while(true)
				mq.Consume();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
	
}
