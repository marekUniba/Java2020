package Backtrack;

import java.util.HashSet;

interface State {
	abstract boolean isFinalState();	// test na koncov� stav h�adania - m��e ich by� ve�a
	abstract HashSet<State> next();			// nasleduj�ci/susedn� stav
	abstract boolean isCorrect();		// test na korektnos� stavu
}