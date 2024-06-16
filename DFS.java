import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
	private Set<String> marked;
	private Map<String, String> edgeTo;
	private String start;
	private Map<String, Integer> longestPath;

	public DFS(Graph G, String start) {
		this.start = start;
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		longestPath = new HashMap<>();
		dfs(G, start);
	}

	public boolean hasPathTo(String v) {
		return marked.contains(v);
	}

	public int longestPathh() {
		// implementar a lógica para achar o maior caminho e retornar a quantidade de caixas que cabem uma dentro da outra
		// não sei como podemos fazer isso :)))))))))))
		return 0;
	}

	Iterable<String> pathTo(String v) {
		if (!hasPathTo(v)) return null;
		ArrayList<String> path = new ArrayList<>();
		String w = v;
		while(!w.equals(start)) {
			path.add(0,w);
			w = edgeTo.get(w);
		}
		path.add(0,start);
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
