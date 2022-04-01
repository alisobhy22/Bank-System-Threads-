
package Bank;
import java.util.Random;
import java.util.Scanner;
public class Teller extends Thread {

	int number;
	queue q;
	Teller(int n, queue queue)
	{
		number = n;
		q = queue;
	}
	 public void run()
	{
		
		while(q.isEmpty() == false || q.done == false)
		{
			
			
			if(q.isEmpty())
			{
				Thread.onSpinWait();
			}
			else
			{
				if(!q.isEmpty())
				{
					Customer a;
					synchronized(q)
					{
					 a = q.deQueue();
					}
					System.out.println("Serving Customer " + a.number + " by Teller number " + number);
					Random rand = new Random();
					int seconds = rand.nextInt(40);
					try {
						Thread.sleep(seconds* 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Served Customer " + a.number+ " by  Teller number " + number+ " After " + seconds + " Seconds");
					}
			}
			
		}
	}
}
