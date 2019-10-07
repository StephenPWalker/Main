package n5_practical3;

public class ProducerConsumer extends Thread
{	
    public static void main(String args[])
    {
    	MyQueue box = new MyQueue();
    	Producer producer = new Producer(box);
    	Consumer consumer = new Consumer(box);   	
    	producer.start();
    	consumer.start();
    }
}
