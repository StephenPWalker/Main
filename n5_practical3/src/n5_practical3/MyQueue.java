package n5_practical3;

import java.util.LinkedList;

public class MyQueue 
{
	private LinkedList<Integer> list;
	private Integer value;
	private int capacity = 10;
	
	public MyQueue()
	{
	 	list = new LinkedList<Integer>();
	 	value = 0;
	}	
	public synchronized void Produce() throws InterruptedException
	{
		while(list.size() == capacity)
			wait();
		
		list.add(1);
		value++;
		System.out.println("Producer produced-" + value);				
		notify();	
	}
	public synchronized void Consume() throws InterruptedException
	{
		while(list.size() == 0)
			wait();
		
		list.remove();	
		System.out.println("Consumer consumed-" + value);	
		value--;
		notify();
	}
	
}
