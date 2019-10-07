
public class SoldItem extends AuctionItem
{
	private int selling;
	public SoldItem(String lotNumber, int estimate, int selling)
	{
		super(lotNumber, estimate);
		this.selling = selling;
	}
	public int getExtra()
	{
		return super.getCost() - this.getCost();
	}
	public int getCost()
	{
		return selling;
	}
}
