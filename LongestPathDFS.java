import java.util.*;

public class LongestPathDFS {
    private Map<Integer, Integer> memo;
    private Digraph grafo;

    public LongestPathDFS(Digraph grafo) {
        this.grafo = grafo;
        this.memo = new HashMap<>();
    }

    public int dfs(int node) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        int maxLength = 1;  // A single node itself is a path of length 1
        for (int neighbor : grafo.getNeighbors(node)) {
            maxLength = Math.max(maxLength, 1 + dfs(neighbor));
        }
        memo.put(node, maxLength);
        return maxLength;
    }

    public int encontrarCaminhoMaisLongo() {
        int maxLength = 0;
        for (int node : grafo.getAdjList().keySet()) {
            maxLength = Math.max(maxLength, dfs(node));
        }
        return maxLength;
    }
}
