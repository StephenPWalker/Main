import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Queue;
import java.lang.String;

import org.junit.Before;
import org.junit.Test;

public class ShopTestTask1 {

	private Shop shop;

	@Before
	public void setUp()
	{
		shop = new Shop();
	}

	@Test
	public void testInitialState()
	{
		Queue<Customer> queue = shop.getQueue();
		assertTrue("Shop queue not empty", queue.isEmpty());
	}

	@Test
	public void testAddCustomer()
	{
		Customer customer1 = new Customer("Jack","11:00");
		shop.addCustomer(customer1);
		Customer customer2 = new Customer("Jill","11:05");
		shop.addCustomer(customer2);
		
		Queue<Customer> queue = shop.getQueue();
		assertEquals("Customer not added successfully to the queue.", 2, queue.size());
		assertEquals("Customer not added succcesfully to the queue.", customer1, queue.peek());
	}

	@Test
	public void testGetNextCustomer()
	{
		Customer customer1 = new Customer("Jack","11:00");
		shop.addCustomer(customer1);
		Customer customer2 = new Customer("Jill","11:05");
		shop.addCustomer(customer2);
		
		assertEquals("Customer not added successfully to the queue.", 2, shop.getQueue().size());
		assertEquals("Customer not added succcesfully to the queue.", customer1, shop.getNextCustomer());
		assertEquals("Customer not added succcesfully to the queue.", customer2, shop.getNextCustomer());
		Queue<Customer> queue = shop.getQueue();
		assertEquals("Customer not added successfully to the queue.", 0, queue.size());
	}
}
