
public class top_gate extends Thread
{
	my_queue gate;

	public top_gate(my_queue m)
	{
		gate = m;
	}
	public void run()
	{
		try 
		{
			while(true)
			{
				gate.tgEnter();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace(); 
		}
	}
}
