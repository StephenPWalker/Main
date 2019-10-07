
public class AuctionItem 
{
	private String lotNumber;
	private int estimate;
	
	public AuctionItem(String lotNumber, int estimate)
	{
		this.lotNumber = lotNumber;
		this.estimate = estimate;
	}
	public String getLotNumber()
	{
		return lotNumber;
	}
	public int getCost()
	{
		return estimate;
	}
	public int getExtra()
	{
		return 0;
	}
}
