import java.lang.String;

/**
 * Representation of a shop customer.
 *
 * @author ces
 * @date 2/2014
 *
 */
public class Customer {

	String name;
	String arrivalTime;

	/**
     * Create a customer with given name and arrival time.
     */
    Customer(String name, String arrivalTime)
    {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }
}
