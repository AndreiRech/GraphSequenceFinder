import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<String>> graph;
  protected Set<String> vertices;
  protected int totalVertices;
  protected int totalEdges;
  protected Box[] boxes;

  public Graph() {
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public Graph(String filename, int size) {
    this();
    int i=0;
    boxes = new Box[size];
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      String[] dimensions = line.split(" ");
      Box box = new Box(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2]));  
      boxes[i] = box;
      i++;
    }
    verifyBoxes(boxes, size);
    in.close();
  }

  private void verifyBoxes(Box[] boxes, int size) {
    for(int i = 0; i < size - 1; i++) {
        for(int j = i + 1; j < size; j++) {
            if(boxes[i].fitInto(boxes[j])) {
                addEdge(String.valueOf(i), String.valueOf(j));
            } else if(boxes[j].fitInto(boxes[i])) {
                addEdge(String.valueOf(j), String.valueOf(i));
            }
        }
    }
}

  public void addEdge(String v, String w) {
    addToList(v, w);
    addToList(w, v);
    if (!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if (!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
  }

  public Iterable<String> getAdj(String v) {
    List<String> res = graph.get(v);
    if (res == null)
      res = new LinkedList<>();
    return res;
  }

  public Set<String> getVerts() {
    return vertices;
  }

  public int getTotalVertices() {
    return totalVertices;
  }

  public int getTotalEdges() {
    return totalEdges;
  }

  public String toDot() {
    Set<String> edges = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    sb.append("graph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (String v : getVerts().stream().sorted().toList()) {
      for (String w : getAdj(v)) {
        String edge = v.compareTo(w) > 0 ? v + w : w + v;
        if (!edges.contains(edge)) {
          sb.append("\"" + v + "\"" + " -- " + "\"" + w + "\"" + NEWLINE);
          edges.add(edge);
        }
      }
    }
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  protected List<String> addToList(String v, String w) {
    List<String> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(w);
    graph.put(v, list);
    totalEdges++;
    return list;
  }
}
