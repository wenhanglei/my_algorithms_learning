
public class EdgeWeightedGraph {
	
	private Bag<Edge>[] edgeTo;
	private final int V;
	private int E;
	/**
	 * 构造函数
	 * @param V
	 */
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		edgeTo = (Bag<Edge>[])new Object[V];
		for(int i = 0; i < edgeTo.length; i++) {
			edgeTo[i] = new Bag<Edge>();
		}
	}
	/**
	 * 构造函数
	 * @param in
	 */
	public EdgeWeightedGraph(In in) {
		this.V = in.readInt();
		edgeTo = (Bag<Edge>[])new Object[V];
		for(int i = 0; i < edgeTo.length; i++)
			edgeTo[i] = new Bag<Edge>();
		E = in.readInt();
		while(in.hasNextLine()) {
			String[] edge = in.readLine().split(" ");
			Edge e = new Edge(Integer.parseInt(edge[0]),
							  Integer.parseInt(edge[1]),
							  Double.parseDouble(edge[2]));
			addEdge(e);
		}	
	}
	/**
	 * @return 返回顶点数
	 */
	public int V() {
		return edgeTo.length;
	}
	/**
	 * @return 返回边数
	 */
	public int E() {
		return E;
	}
	/**
	 * 添加边
	 * @param e
	 */
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		edgeTo[v].add(e);
		edgeTo[w].add(e);
		E++;
	}
	/**
	 * @param v
	 * @return 返回顶点v的所有邻边
	 */
	public Iterable<Edge> adj(int v) {
		return edgeTo[v];
	}
	/**
	 * @return 该图的所有边
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> edges = new Bag<Edge>();
		for(int i = 0; i < V; i++){
			for(Edge e : edgeTo[i]){
				if(e.other(i) > i) edges.add(e);
			}
		}
		return edges;
	}
}
















