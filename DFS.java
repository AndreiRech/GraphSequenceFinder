import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
	private Set<String> marked;
	private Map<String, String> edgeTo;
	private Map<String, Integer> longestPath;
	private int longestLenght;

	public DFS(Graph G) {
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		longestPath = new HashMap<>();
		longestLenght = 0;
		dfs(G, "0");
	}

	public boolean hasPathTo(String v) {
		return marked.contains(v);
	}

	public int longestLenght() {
		return longestLenght;
	}

	Iterable<String> pathTo(String v) {
		if (!hasPathTo(v)) return null;
		ArrayList<String> path = new ArrayList<>();
		String w = v;
		while(edgeTo.containsKey(w)) {
			path.add(0,w);
			w = edgeTo.get(w);
		}
		path.add(0,w);
		return path;
	}

	private void dfs(Graph g, String s) {
		marked.add(s);
		for (String w : g.getAdj(s)) {
			if (!marked.contains(w)) {
				edgeTo.put(w, s);
				dfs(g, w);
			}
		}	
	}
}
