package Riesenie;

import java.util.ArrayList;

/**
 * implementacia prioritneho frontu pomocu pola
 * @param <E>
 *  v rieseni ArrayPF sa mi nepacia dve polia, chcelo by to dvojicu, resp. objekt,
 *  ktory obsahuje E aj priotitu int.
 *  Java je jeden z jazykov, ktory nema poriadne dvojicu, az tu najdete nieco hotove
 *  javafx.util.Pair<K,V>
 *  takze si to radsej urobme sami...
 *  dalsi problem, ktory musite pochopit, ze pole Dvojica<E>[] nikdy nevyrobite.
 *  je to dosledok konavriancie poli, a nekovarianice generickych typov, viac v prednaske...
 *  takze si trochu pomozem ArrayListom, kto nerozumie, vrati sa sem o tyzden...
 */
class Dvojica<E> {
	E elem;
	int prio;

	public Dvojica(E elem, int prio) {
		this.elem = elem;
		this.prio = prio;
	}
}
public class ArrayPFDvojica<E> implements FrontInterface<E> {
	private ArrayList<Dvojica<E>> f;
	/**
	 * konstruktor
	 */
	public ArrayPFDvojica(int size) {
		f = new ArrayList<Dvojica<E>>();
	}
	/**
	 * zarad prvok elem s prioritou prio
	 */
	@Override
	public void enqueue(E elem, int prio) {
		// ako vsunut do utriedeneho zoznam s indexami, aby zostalo utriedene
		int index = 0;
		for(; index < f.size(); index++) {
			if (f.get(index).prio > prio) {
				break;
			}
		}
		f.add(index, new Dvojica<E>(elem, prio));
	}

	/**
	 * vyber prvok s najmensou prioritou
	 */
	@Override
	public E dequeue() {
		E res = null;
		if (!isEmpty()) {
			res = f.get(0).elem;
			f.remove(0);
		}
		return res;
	}
	/**
	 * test, ci je front prazdny
	 */
	@Override
	public boolean isEmpty() {
		return f.size() == 0;
	}
	@Override
	public String toString() {
		String res = "";
		for(Dvojica<E> d : f) {
			res += d.elem + ",";
		}
		return res;
	}

	 public static void main(String[] args) {
  	    ArrayPFDvojica<String> f = new ArrayPFDvojica<>(100);
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
}
