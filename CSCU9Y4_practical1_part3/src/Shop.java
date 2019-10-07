import java.util.LinkedList;
import java.util.Queue;

/**
 * An extended model of a shop, consisting of an array of queues of customers.
 *
 * @author ces
 * @date 2/2014
 *
 */
public class Shop
{
	/**
	 * An array of queues of all customers currently in the shop.
	 */
	private int numberOfTills;
	private Queue<Customer>[] queues;

	/**
	 * Construct a new shop. This should initialise the empty queues.
	 */
	@SuppressWarnings("unchecked")
	public Shop(int tills)
	{
		numberOfTills = tills;
		queues = new Queue[numberOfTills];
		// Java supports multiple types of queues so we cannot simply ask for a new Queue...
		// One type of queue is a LinkedList, which is what we are using here.
		// For more information check the Javadocs.
		// assume index runs from 1 .. but array indices run from 0..
		for (int i = 0; i < numberOfTills; i +=1){
		    queues[i] = new LinkedList<Customer>();
		  }
	}

	/**
	 * Gets the specified queue of customers currently in the shop.
	 *
	 * @return the queue of customers currently in the shop.
	 */
	public Queue<Customer> getQueue(int index)
	{
		return queues[index-1];
	}
	
	/**
	 * Add a new customer to the back of one of the queues.
	 *
	 * @param customer the customer to enqueue.
	 * @param index the queue to put the customer in.
	 */
	public void addCustomer(Customer customer, int index)
	{
		queues[index-1].add(customer);
	}

	/**
	 * Get the next customer from the front of one of the queues.
	 *
	 * @param index the queue to take the customer from.
	 * @return the next customer in the queue.
	 */
	public Customer getNextCustomer(int index)
	{
		Customer frontCustomer = queues[index-1].remove();
		return frontCustomer;
	}
}
