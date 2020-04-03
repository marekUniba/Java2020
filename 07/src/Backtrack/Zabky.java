package Backtrack;

import java.util.HashSet;


class ZabkyState implements State {
	public String z7;
	public ZabkyState() {
		z7 = ">>> <<<";
	}
	public ZabkyState(String s) {
		z7 = s;
	}
	public String toString() {
		return z7.toString();
	}
	@Override
	public boolean equals(Object o) {
		return z7.equals(((ZabkyState)o).z7);
	}
	public ZabkyState initState() {
		return new ZabkyState();
	}
	public boolean isFinalState() {
		return z7.equals("<<< >>>");
	}

	public HashSet<State> next()  {
		HashSet<State> nxt = new HashSet<>();
		nxt.add(new ZabkyState( z7.replace(" <", "< ")));
		nxt.add(new ZabkyState( new String(z7).replace("> ", " >")));
		nxt.add(new ZabkyState( new String(z7).replace(" ><", "<> ")));
		nxt.add(new ZabkyState( new String(z7).replace(">< ", " <>")));
		nxt.remove(this);
		return nxt;
	}
	public boolean isCorrect() {
		return true;
	}
}

public class Zabky {
	public static void main(String[] args) {
		System.out.println(	"><<< >>".replace(" <", "< "));
		ZabkyState p = new ZabkyState();
		Search<ZabkyState> search = new Search<>();
		search.search(p.initState());
		System.out.println(search);
	}
}
