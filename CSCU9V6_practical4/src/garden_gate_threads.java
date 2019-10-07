public class garden_gate_threads
{	
	static public void main(String[] args) 
	{	
		my_queue q = new my_queue();
    	bottom_gate bg = new bottom_gate(q);
    	top_gate tg = new top_gate(q);   	
    	
    	bg.start();
    	tg.start();
	}
}

