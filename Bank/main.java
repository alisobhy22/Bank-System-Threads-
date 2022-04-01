package Bank;
import java.util.Scanner;
import java.util.Random;


public class main {

	public static void main(String[] args) {
		int no_of_customers = 0;
		int N, M;
		System.out.println("Hello and welcome to the bank queue system!");
		System.out.println("Please start out by etnering N and M (N tellers and M number of customers)");
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		Bank_System b = new Bank_System(N,M);
		b.start();
		while(b.q.number_of_customers < b.q.SIZE)
		{
			b.update_tellers_queue();
		}
	}
		



}

