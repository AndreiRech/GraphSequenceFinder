import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {

	private Set<String> marked;
	private Map<String, String> edgeTo;
	private String start;

	public DFS(Graph G, String start) {
		this.start = start;
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		dfs(G, start);
	}

	boolean hasPathTo(String v) {
		return marked.contains(v);
	}

	Iterable<String> pathTo(String v) {
		if (!hasPathTo(v)) return null;
		ArrayList<String> path = new ArrayList<>();
		String w = v;
		while(!w.equals(start)) {
			path.add(0,w); // insere no início da lista
			w = edgeTo.get(w);
		}
		path.add(0,start);
		return path;
	}

	private void dfs(Graph g, String s) {
		System.out.println("Visitando: " + s);
		marked.add(s);
		for (String w : g.getAdj(s)) {
			if (!marked.contains(w)) {
				edgeTo.put(w, s);
				dfs(g, w);
			}
		}	
	}
}
