
public class bottom_gate extends Thread
{
	my_queue gate;

	public bottom_gate(my_queue m)
	{
		gate = m;
	}
	public void run()
	{
		try 
		{
			while(true)
			{
				gate.bgEnter();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
}
