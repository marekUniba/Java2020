package Backtrack;

import java.util.ArrayList;
import java.util.ArrayList;

public class Search<S extends State> {
	ArrayList<S> riesenia;

	public Search() {
		riesenia = new ArrayList<S>();
	}

	public void add(S s) {
		riesenia.add(s);
	}

	public String toString() {
		return "" + riesenia.toString() + "\n" + riesenia.size();
	}

	/**
	 * tento sa zacykli pri cyklickom grafe
	 */
	public void searchWhichLoops(S s) {
		if (s.isFinalState()) 
			add(s);
		else
			for (State ns : s.next())
				search((S) ns);
	}

	public void search(S s) {
		ArrayList<S> visited = new ArrayList<S>();
		search(s, visited);
	}

	
	public void search(S s, ArrayList<S> visited) {
		if (s.isFinalState()) {
			add(s);
			System.out.println("final state:" + s + " visited: " + visited );
		} else
			for (State ns : s.next()) {
				if (!visited.contains(ns) && ns.isCorrect()) {
					visited.add((S) ns);
					search((S) ns, visited);
					visited.remove(ns);
				}
			}
	}

	public void search(S s, boolean DFS) {
		ArrayList<S> queue = new ArrayList<S>();
		queue.add(s);
		ArrayList<S> visited = new ArrayList<S>();
		search(queue, visited, DFS);
	}

	private void search(ArrayList<S> queue, ArrayList<S> visited, boolean DFS) {
		while (queue.size() > 0) {
			S s = queue.remove(0);
			if (s.isFinalState()) {
				add(s);
			} else {
				for (State ns : s.next()) {
					if (!visited.contains(ns) && ns.isCorrect()) {
						visited.add((S) ns);
						if (DFS)
							queue.add(0, (S) ns);
						else
							queue.add(queue.size(), (S) ns);
					}
				}
			}
		}
	}
	
	private void search(ArrayList<S> queue, ArrayList<S> visited, ArrayList<S> comeFrom, boolean DFS) {
		while (queue.size() > 0) {
			S s = queue.remove(0);
			if (s.isFinalState()) {
				add(s);
			} else {
				for (State ns : s.next()) {
					if (!visited.contains(ns) && ns.isCorrect()) {
						visited.add((S) ns);
						comeFrom.add((S) s);
						if (DFS) {
							queue.add(0, (S) ns);
						} else
							queue.add(queue.size(), (S) ns);
					}
				}
			}
		}
	}
	
}
