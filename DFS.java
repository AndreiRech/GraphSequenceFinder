import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
	private Set<String> marked;
	private Map<String, String> edgeTo;
	private Map<String, Integer> longestPath;
	private int longestLenght, steps;

	public DFS(Graph G) {
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		longestPath = new HashMap<>();
		longestLenght = 0;
		steps = 0;
		findLongestPath(G);
	}

	public int longestLenght() {
		return longestLenght;
	}

	public int steps() {
		return steps;
	}

	private void findLongestPath(Graph G) {
		for (String actualVertex : G.getVerts()) {
            marked.clear();
            edgeTo.clear();
            longestPath.clear();
            dfs(G, actualVertex);
        }
	}

	private void dfs(Graph g, String s) {
		marked.add(s);
		longestPath.put(s, 1);
		for (String w : g.getAdj(s)) {
			if (!marked.contains(w)) {
				edgeTo.put(w, s);
				steps++;
				dfs(g, w);
			}
			longestPath.put(s, Math.max(longestPath.get(s), 1 + longestPath.get(w)));
		}
		longestLenght = Math.max(longestLenght, longestPath.get(s));
	}
}
