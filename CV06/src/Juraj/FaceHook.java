package Juraj;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FaceHook<T> {
    Map<T, Set<T>> graph = new HashMap<>();

    @Override
    public String toString() {
        return "FaceHook{" + graph + '}';
    }

    public void blizkiPriatelia(T meno1, T meno2) {
        if (meno1.equals(meno2)) {
            return;
        }
        if (!graph.containsKey(meno1)) {
            graph.put(meno1, new HashSet<>());
        }
        if (!graph.containsKey(meno2)) {
            graph.put(meno2, new HashSet<>());
        }
        graph.get(meno1).add(meno2);
        graph.get(meno2).add(meno1);
    }

    public Set<T> vsetci() {
        return new HashSet<>(graph.keySet());
    }

    public int pocetPriatelov(T meno) {
        return graph.getOrDefault(meno, Set.of()).size();
    }

    public int spolocniPriatelia(T meno1, T meno2) {
        Set<T> intersection = new HashSet<>(graph.getOrDefault(meno1, Set.of()));
        intersection.retainAll(graph.getOrDefault(meno2, Set.of()));
        return intersection.size();
    }

    private boolean vzdialenyPriatelRec(T start, T end, Set<T> visited){
        if (start.equals(end)) { return true; }
        if (!visited.add(start)) { return false; }
        return graph.get(start).stream().anyMatch(n -> vzdialenyPriatelRec(n, end, visited));
    }

    public boolean vzdialenyPriatel(T meno1, T meno2) {
        if(!graph.containsKey(meno1) || !graph.containsKey(meno2)){
            return false;
        }
        return vzdialenyPriatelRec(meno1, meno2, new HashSet<>());
    }
}
