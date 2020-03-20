package Riesenie;

/**
 * implementacia prioritneho frontu spajaneho zoznamu s hodntami typu E
 * v tomto pripade je spajany zoznam prvkov typu E, pricom je utriedeny opat podla rastucich priorit
 * najnizsia priorita je na zaciatku
 * dequeue je lahle, pri enqueue treba sikovne najst miesto, kam treba prvok vsunut
 */

public class ListPF<E> implements FrontInterface<E> {
	Elem<E> first;		// Elem je krabica spajaneho zoznamu a je ako trieda definovana
						// na konci tejto triedy
						// ano, v subore moze byt definicia viacerych tried, aj ked vam to neprezradili
					    // ale len jedna moze byt public, ostatne nie

	/**
	 * konstruktor
	 */
	public ListPF() {
		first = null;
	}
	/**
	 * zarad prvok elem s prioritou prio
	 */
	@Override
	public void enqueue(E elem, int prio) {
		Elem<E> front = first;		// ide po spajanom zozname
		Elem<E> back = null;		// ide ale o krok pomalsie
		while (front != null && front.getPrior() < prio) {
			back = front;
			front = front.getNext();
		}
		Elem<E> novy = new Elem<E>(prio, elem, front);
		if (back == null)
			first = novy;
		else
			back.setNext(novy);
	}
	/**
	 * vyber prvok s najmensou prioritou
	 */
	@Override
	public E dequeue() {
		if (isEmpty())
			return null;
		else {
			E tmp = first.getElement();
			first = first.getNext();
			return tmp;
		}
	}
	/**
	 * test, ci je front prazdny
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	 public static void main(String[] args) {
		 ListPF<String> f = new ListPF<>();
	        f.enqueue(new String("janka"), 5);
	        f.enqueue(new String("danka"), 2);
	        f.enqueue(new String("hanka"), 1);
	        f.enqueue(new String("anka"), 4);
	        f.enqueue(new String("zuzanka"), 3);
	        f.enqueue(new String("elenka"), 1);
	        f.enqueue(new String("zofka"), 6);
	        f.enqueue(new String("evka"), 4);
	        System.out.println(f);
	        while (!f.isEmpty())
	            System.out.println(f.dequeue());    
	    }

	/**
	 * toto je trieda, ktoru mozete pouzit na spajany zoznam
 	 * @param <E>
	 */
	private static class Elem<E> {
	  private int prior;		// priorita prvku
	  private E element;		// hodnota prvku
	  private Elem<E> next;		// link na nasledujuci prvok
		/**
			konstruktor krabice
		 */
	  public Elem(int prior, E element, Elem<E> next){
		this.prior = prior;
		this.next = next;
		this.element = element;
	  }
		/**
		 * gettery
		 */
	  public int getPrior(){
		  return prior;
	  }
	  public Elem<E> getNext(){
		return next;
	  }
		/**
		 * settery
		 */
	  public E getElement(){
		  return element;
	  }
	  public void setNext(Elem<E> new_next){
		next = new_next;
	  }
	}
}
