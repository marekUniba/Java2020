package Riesenie;

/**
 * implementacia prioritneho frontu pomocu pola
 * @param <E>
 *  idea, ktoru realizujte: konstruktor naalokuje pole velkosti size.
 *  Nejde to urobit takto E[] pole = new E[size], dovody su v prednaske
 *  Ide to urobit takto E[] pole = (E[])new Object[size]
 *  dequeue musi vratit prvok s najmensou prioritou, preto je najrozumnejsie, aby bole prvkov typu E bolo
 *  utriedene podla priorit, od najmensej po najvacsiu. Kedze prvky pribudaju a ubudaju, zistite z prednasky
 *  ako sa implementuje front v poli efektivne, aby ste ho stale neposuvali v poli. Stacia na to dva indexy, prvy
 *  a posledny, a rozmyslat, ze front moze odkracat cez hranu pola. Modulo size vas zahrani.
 *  Ak mate pole utriedene, tak dequeue je trivialne, vyberie prvy prvok frontu.
 */
public class ArrayPF<E> implements FrontInterface<E> {
	private E[] f;
	private int[] priority;
	private int first;
	private int last;
	// z DU4, tam aj vysvetlene
	private int mod(int index) {
		return mymodulo(index, f.length);
	}
	private static int mymodulo(int a, int b) {
		int m = a % b;
		if (m < 0) {
			m = (b < 0) ? m - b : m + b;
		}
		return m;
	}
	/**
	 * konstruktor
	 */
	@SuppressWarnings("unchecked")
	public ArrayPF(int size) {
		f = (E[])new Object[size];
		priority = new int[size];
		first = 0;
		last = 0;
	}
	public boolean isFull() {
		return mod(last+1) == first;
	}
	/**
	 * zarad prvok elem s prioritou prio
	 */
	@Override
	public void enqueue(E elem, int prio) {
		if (isFull()) { // realokacia, vsetko z DU4
			System.out.println("realloc");
			E[] newf = (E[])new Object[2*f.length];
			int[] priorityf = new int[2*f.length];
			int j = 0;
			int i = first;
			while (i != last) {
				newf[j] = f[i];
				priorityf[j++] = priority[i];
				i = mod(i+1);
			}
			first = 0;
			last = j;
			f = newf;
			priority = priorityf;
		} // tu je zmena, predpokladame, ze objekty su v f usporiadane podla priorit
		// ako vsunut do utriedeneho pola s indexami [first..last) prvok, aby zostalo utriedene

		// od konca !!!
//		int index = last;
//		int index1 = mod(index-1);
//		while (index != first && priority[index1] > prio) {
//			f[index] = f[index1];
//			priority[index] = priority[index1];
//			index = index1;
//			index1 = mod(index-1);
//		}
//		// tu uz plati, ze priority[index1] <= prio
//		f[index] = elem;
//		priority[index] = prio;
//		last = mod(last+1);

		// od zaciatku ...
		int index = first;
		int index_1 = mod(first-1);
		first = index_1;
		while(priority[index] < prio && index != last) {
			f[index_1] = f[index];
			priority[index_1] = priority[index];
			index = mod(index+1);
			index_1 = mod(index_1+1);
		}
		f[index_1] = elem;
		priority[index_1] = prio;
	}

	/**
	 * vyber prvok s najmensou prioritou
	 */
	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			E el = f[first];
			first = mod(first+1);
			return el;
		}
	}
	/**
	 * test, ci je front prazdny
	 */
	@Override
	public boolean isEmpty() {
		return first == last;
	}
	@Override
	public String toString() {
		String res = "";
		int i = first;
		while (i != last) {
			res += f[i] + ",";
			i = mod(i+1);
		}
		return res;
	}

	 public static void main(String[] args) {
  	    ArrayPF<String> f = new ArrayPF<>(100);
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
