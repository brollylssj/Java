package queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Kolejki 
{
	

	public static void main(String[] args) 
	{
	
		ArrayDeque<String> deq = new ArrayDeque<>();
		// Dzia³a jak kojka FIFO
		
		deq.offer("Ala");
		deq.add("ma");
		deq.add("kota");
		
		System.out.println("Kolejka FIFO z Deque "+ deq);
		System.out.println("Pocz¹tkowa nazwa tego ciula" + deq.peek());
		
		
		// LIFO
		
		deq.clear();
		deq.addFirst("jest");
		deq.addFirst("zajebiscie");
		deq.addFirst("no nie");
		
		
		System.out.println(" LIFO");
		for(String i :deq)
		{
			System.out.println(i);
		}

		
		
		// kolejka priorytetowa
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		pq.add("dupa");
		pq.add("siedzi");
		pq.add("mi");
		
		boolean s;
		
		while((s = pq.poll() !=null))
		{
			System.out.println(s);
		}
	}

}
