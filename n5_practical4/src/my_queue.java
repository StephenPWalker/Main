import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class my_queue
{
	private LinkedList<Byte> queue = new LinkedList<Byte>(); 
	int internal_count;
	int count;
	byte t[] = { 0 };
	RandomAccessFile admin;
	
	public my_queue()
	{
		try 
		{
			admin = new RandomAccessFile("admin.txt", "rw");
			admin.seek(0);
			admin.write(t);
		} 
		catch (IOException e) 
		{
			
		}
		internal_count = 0;
		count = 0;
	}
	public synchronized void tgEnter() throws InterruptedException, IOException
	{				
		admin.seek(0);
		admin.read(t);
		count = t[0];
		count++;
		internal_count++;
		t[0] = (byte) count;
		admin.seek(0);
		admin.write(t);
		queue.add((byte)count);
		System.out.println("Top gate entered, Total : " + count + " , Internal total : " + internal_count);				
		notify();
	}
	public synchronized void bgEnter() throws InterruptedException, IOException
	{		
		admin.seek(0);
		admin.read(t);
		count = t[0];
		count++;
		internal_count++;
		t[0] = (byte) count;
		admin.seek(0);
		admin.write(t);
		queue.add((byte)count);
		System.out.println("Bottom gate entered, Total : " + count + " , Internal total : " + internal_count);					
		notify();	
	}
	public int getCount()
	{
		return count;
	}
}
