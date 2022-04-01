package Bank;
import java.util.Scanner;
import java.util.Random;

public class queue extends Thread {
	
	int number_of_customers; 
	int SIZE;
	  Customer items[];
	  int front, rear;
	  boolean done;

	  queue(int s) {
		  done = false;
		  number_of_customers = 0;
		  SIZE = s;
		  items = new Customer[SIZE];
	    front = -1;
	    rear = -1;
	  }

	  // check if the queue is full
	  boolean isFull() {
	    if (front == 0 && rear == SIZE - 1) {
	      return true;
	    }
	    return false;
	  }

	  // check if the queue is empty
	  boolean isEmpty() {
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }
	  void addAtFront(Customer E)
	  {
		 enQueue(E);
		  int n = rear;
	        for (int i = 0; i < n; i++)
	            for (int j = 0; j < n-i; j++)
	                {
	            	if (items[j].VIP < items[j+1].VIP)
	                
	                {
	                    Customer temp = items[j];
	                    items[j] = items[j+1];
	                    items[j+1] = temp;
	                
	                }
	                }
		  
	  }
	  // insert elements to the queue
	  void enQueue(Customer element) {
	    // if queue is full
	    if (isFull()) {
	      System.out.println("Queue is full");
	    }
	    else {
	      if (front == -1) {
	        // mark front denote first element of queue
	        front = 0;
	      }

	      rear++;
	      // insert element at the rear
	      items[rear] = element;
	    }
	  }

	  // delete element from the queue
	  Customer deQueue() {
	    Customer element;

	    // if queue is empty
	    if (isEmpty()) {
	      System.out.println("Queue is empty");
	      return (null);
	    }
	    else {
	      // remove element from the front of queue
	      element = items[front];

	      // if the queue has only one element
	      if (front >= rear) {
	        front = -1;
	        rear = -1;
	      }
	      else {
	        // mark next element as the front
	        front++;
	      }
	      return (element);
	    }
	  }

	  // display element of the queue
	  void display() {
	    int i;
	    if (isEmpty()) {
	      System.out.println("Empty Queue");
	    }
	    else {
	      // display the front of the queue
	      System.out.println("\nFront index-> " + front);

	      // display element of the queue
	      System.out.println("Items -> ");
	      for (i = front; i <= rear; i++)
	        System.out.print(items[i].number + "  ");

	      // display the rear of the queue
	      System.out.println("\nRear index-> " + rear);
	    }
	  }
	  public void run()
	  {
		  while(number_of_customers < SIZE)
		  {
		  Scanner input = new Scanner(System.in);
		  try {

				Random rand = new Random();

				int seconds = rand.nextInt(10);

				Thread.sleep(seconds * 1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  number_of_customers++;
		  System.out.println("We have a new customer, please enter if he is a VIP or not by typing 1 for VIP and 0 for regular");
			int answer = input.nextInt();
			Customer a = new Customer(answer,number_of_customers);
			synchronized(this)
			{
			if(answer == 0)
			this.enQueue(a);
			else this.addAtFront(a);
			}
				
		  }
		  done = true;
	  }
	  
}

