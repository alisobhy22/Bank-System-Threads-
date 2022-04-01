package Bank;


public class Bank_System extends Thread {
	int N,M;
	queue q;
	Teller[] t;
	
	Bank_System(int n,int m)
	{
		N = n;
		M = m;
		t = new Teller[N];
		q = new queue(M);
		for(int i = 0; i < N; i++)
		{
			t[i] = new Teller(i+1,q);
		}

	}
	public void update_tellers_queue()
	{
		for(int i = 0; i < N; i++)
		{
			t[i].q = this.q;
		}
	}
	public synchronized void run()
	{
		
		q.start();
		try {
			Thread.sleep(20*1000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		for(int j = 0; j < N; j++)
		{
			t[j].start();
		
		}
	}
}