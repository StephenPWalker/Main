package n5_practical3;

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
			{
				mq.Consume();
				Thread.sleep(500);	
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
	
}
