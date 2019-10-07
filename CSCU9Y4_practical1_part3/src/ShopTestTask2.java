import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.String;
import org.junit.Before;
import org.junit.Test;

public class ShopTestTask2 {

    private Shop shop;

	@Before
	public void setUp()
	{
		shop = new Shop(5);
	}
	
	@Test
    public void testInitialState()
    {
        for (int tillNumber = 1;tillNumber <= 5;tillNumber++)
        {
            assertNotNull("Queue " + tillNumber + " not initialised within the array.", shop.getQueue(tillNumber));
            assertTrue("Queue " + tillNumber + " not empty", shop.getQueue(tillNumber).isEmpty());
        }
    }

    @Test
    public void testTillNumber()
    {
        try
        {
            assertNotNull(shop.getQueue(1));
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            assertTrue("Till numbers start at 1, array indexes start at 0!", false);
        }
    }

    @Test
    public void testAddCustomer()
    {
        Customer customer1 = new Customer("Jack","11:00");
        int randomNo = (int)(Math.random() * 5 + 1);
        shop.addCustomer(customer1, randomNo);
        
        assertEquals("Customers not added successfully to the queues.", customer1, shop.getQueue(randomNo).peek());
        /*
        for (int tillNumber = 2;tillNumber <= 5;tillNumber++)
        {
            assertTrue("Queue " + tillNumber + " should still be empty, we only added to queue 1!", shop.getQueue(tillNumber).isEmpty());
        }
        */
    }

    @Test
    public void testGetNextCustomer()
    {
        Customer customer1 = new Customer("Jack","11:00");
        Customer customer2 = new Customer("Jill","11:10");
        Customer customer3 = new Customer("Brian","11:25");
        
        shop.addCustomer(customer1, 1);
        shop.addCustomer(customer2, 3);
        shop.addCustomer(customer3, 1);

        assertEquals("Getting next customer from the queue failed.", customer1, shop.getNextCustomer(1));
        assertEquals("Getting next customer from the queue failed.", customer2, shop.getNextCustomer(3));
        assertEquals("Getting next customer from the queue failed.", customer3, shop.getNextCustomer(1));

        for (int tillNumber = 1;tillNumber <= 5;tillNumber++)
        {
            assertTrue("Queue " + tillNumber + " is not empty after getting all customers.", shop.getQueue(tillNumber).isEmpty());
        }
    }
}
