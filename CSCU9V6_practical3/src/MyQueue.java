import java.util.LinkedList;

public class MyQueue 
{
	private LinkedList<Integer> list;
	private int value;
	private int capacity = 10;
	
	public MyQueue()
	{
	 	list = new LinkedList<Integer>();
	}
	
	public synchronized void Produce(int num) throws InterruptedException
	{
		while(list.size() == capacity)
			wait();
		
		list.add(num);
		value += num;
		System.out.println("Producer produced : " + value);				
		Thread.sleep(500);	
		notify();	
	}
	public synchronized void Consume() throws InterruptedException
	{
		while(list.size() == 0)
			wait();
		
		list.remove();	
		System.out.println("Consumer consumed : " + value);	
		value--;
		Thread.sleep(500);	
		notify();
	}
	
}
