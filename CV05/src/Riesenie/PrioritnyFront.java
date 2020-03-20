package Riesenie; /** PrioritnyFront pomocou PriorityQueue
 *  Java contains a class PrioirtyQueue, we can utilize it for our purpose, and simply implement a wrapper.
 */

import java.util.PriorityQueue;

public class PrioritnyFront<E> implements FrontInterface<E> {
	private class Elem<E> implements Comparable<Elem<E>> {
		public E elem;
		public int prio;

		public Elem(E elem, int prio) { 		// constructor
			this.elem = elem;
			this.prio = prio;
		}
		/**
		 * porovnavanie -1 ak this < other, 0 ak this == other, 1 ak this > other
		 */
		public int compareTo(Elem<E> other) {  // java.lang.PriorityQueue requires comparable elements
			if (prio > other.prio) return 1;
			else if (prio < other.prio) return -1;
			return 0;
		}
		@Override
		public String toString() {
			return "Elem{" +
					"elem=" + elem +
					", prio=" + prio +
					'}';
		}
	}
	
	/** representation of the priority queue is based on java.util.PriorityQueue */
	PriorityQueue<Elem<E>> q;
	
	/** constructor */
	public PrioritnyFront()
	{ 
		q = new PriorityQueue<Elem<E>>();
	}
	
	/** add new element to priority queue */
	public void enqueue(E elem, int prio)
	{
		q.add(new Elem<E>(elem,prio));
	}
	
	/** remove (and return) the element with the highest priority from queue */
	public E dequeue()
	{
		return q.poll().elem;
	}

	@Override
	public boolean isEmpty() {
		return q.size() == 0;
	}
	/** return the element with the highest priority from queue, but do not remove it */ 
	public E front()
	{
		return q.peek().elem;
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		for(Elem e :q) res.append(e+", ");
		return res.toString();
	}
	public static void main(String[] args) {
		PrioritnyFront<String> fs = new PrioritnyFront<>();
		fs.enqueue(new String("janka"), 5);
		fs.enqueue(new String("danka"), 2);
		fs.enqueue(new String("hanka"), 1);
		fs.enqueue(new String("anka"), 4);
		fs.enqueue(new String("zuzanka"), 3);
		fs.enqueue(new String("elenka"), 1);
		fs.enqueue(new String("zofka"), 6);
		fs.enqueue(new String("evka"), 4);
		System.out.println(fs);
		while (!fs.isEmpty())
			System.out.println(fs.dequeue());

		//------------------------------

		// create our implementation of the priority queue
		PrioritnyFront<Integer> f = new PrioritnyFront<>();
		// generate 10 random numbers 0-49 and insert them on the queue
		// with the same priority as their value
		for (int i = 0; i < 10; i++) {
			int x = (int)(50 * Math.random());
			f.enqueue(x, x);
		}
		// now remove the numbers from the queue in the priority order and print them
		for (int i = 0; i < 10; i++)
			System.out.print(f.dequeue() + ",");
		if (f.isEmpty()) System.out.println("empty");

	}
}
