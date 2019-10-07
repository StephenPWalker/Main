
public class AuctionItemTest 
{
	public static void main(String[] args)
	{
		AuctionItem a1 = new SoldItem("v26", 192, 185);
		int cost = a1.getCost();
		int theExtra = a1.getExtra();
		System.out.println("Cost: " + cost + "\nExtra: " + theExtra);
	}
}
