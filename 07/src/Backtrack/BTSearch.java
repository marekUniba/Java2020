package Backtrack;

import java.util.ArrayList;
import java.util.HashSet;

public class BTSearch<St extends State> {

	public void search(St s, HashSet<St> visited) {
		if (s.isFinalState())
			System.out.println(visited);
		else
			for (State ns : s.next()) {
				St ns_ = (St)ns;  // pretypovanie State na St
				if (!visited.contains(ns_)) {
					visited.add(ns_);
					search(ns_, visited);
					visited.remove(ns_);
				}
			}
	}
	
	public void searchDFSBFS(ArrayList<St> queue, HashSet<St> visited, boolean DFS) {
		while (queue.size() > 0) {
			State s = queue.remove(0);
			if (s.isFinalState()) {
				System.out.println("dostal som sa !");
				break;
			}
			HashSet<St> ns = (HashSet<St>)s.next(); // pretypovanie State na St
			ns.removeAll(visited);
			if (DFS)
				queue.addAll(0,ns);
			else
				queue.addAll(queue.size()-1, ns);
		}
	}
}
