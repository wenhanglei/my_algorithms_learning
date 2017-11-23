
public class EdgeWeightedDigraph {
	
	//保存所有边的list
	private Bag<DirectedEdge>[] edges;
	//加权有向图的总的顶点数
	private final int V;
	//加权有向图的边的数量
	private int E;
	
	/**
	 * 加权有向图的构造函数
	 * @param v 总顶点数
	 */
	public EdgeWeightedDigraph(int v) {
		this.V = v;
		edges = (Bag<DirectedEdge>[]) new Object[v];
		for(int i = 0; i < v; i++) 
			edges[i] = new Bag<DirectedEdge>();
		E = 0;
	}
	
	/**
	 * 加权有向图的构造函数
	 * @param in 输入流
	 */
	public EdgeWeightedDigraph(In in) {
		this.V = in.readInt();
		edges = (Bag<DirectedEdge>[])new Object[V];
		for(int i = 0; i < edges.length; i++)
			edges[i] = new Bag<DirectedEdge>();
		E = in.readInt();
		while(in.hasNextLine()) {
			String[] edge = in.readLine().split(" ");
			DirectedEdge e = new DirectedEdge(Integer.parseInt(edge[0]),
											  Integer.parseInt(edge[1]),
											  Double.parseDouble(edge[2]));
			addEdge(e);
		}
	}
	/**
	 * @return 加权有向图的顶点数 
	 */
	public int V(){
		return V;
	}
	/**
	 * @return 加权有向图的边的个数
	 */
	public int E(){
		return E;
	}
	/**
	 * 添加加权有向边
	 * @param e
	 */
	public void addEdge(DirectedEdge e){
		edges[e.from()].add(e);
		E++;
	}
	/**
	 * @param v
	 * @return 所有与顶点v相连接的加权有向边
	 */
	public Iterable<DirectedEdge> adj(int v) {
		return edges[v];
	}
	/**
	 * @return 返回加权有向图的所有边
	 */
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> q = new Bag<DirectedEdge>();
		for(int i = 0; i < edges.length; i++) {
			for(DirectedEdge e : edges[i]){
				q.add(e);
			}
		}
		return q;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}



















