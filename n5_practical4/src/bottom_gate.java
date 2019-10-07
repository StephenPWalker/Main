import java.io.IOException;

public class bottom_gate extends Thread
{
	my_queue gate;
	int value;

	public bottom_gate(my_queue m)
	{
		gate = m;
	}
	public void run()
	{
		try 
		{
			while(value < 100)
			{
				gate.bgEnter();
				Thread.sleep(300);
				value = gate.getCount();
			}
		}
		catch(InterruptedException | IOException e)
		{
			e.printStackTrace(); 
		}
	}
}
