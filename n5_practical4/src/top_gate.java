import java.io.IOException;

public class top_gate extends Thread
{
	my_queue gate;
	int value;

	public top_gate(my_queue m)
	{
		gate = m;
	}
	public void run()
	{
		try 
		{
			while(value < 100)
			{
				gate.tgEnter();
				Thread.sleep(500);
				value = gate.getCount();
			}
		}
		catch(InterruptedException | IOException e)
		{
			e.printStackTrace(); 
		}
	}
}
