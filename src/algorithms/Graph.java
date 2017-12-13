package algorithms;

public class Graph {
	
	//使用邻接链表数组作为图的底层数据结构
	private Bag<Integer>[] adj;
	//图的顶点数量
	private final int V;
	//图的边数
	private int E;
	
	/**
	 * 图的构造函数
	 * @param V
	 */
	public Graph(int V) {
		this.V = V; 
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	/**
	 * 输入流构造函数
	 * @param in
	 */
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	/**
	 * 图的顶点数
	 * @return
	 */
	public int V(){
		return V;
	}
	/**
	 * 图的边数
	 * @return
	 */
	public int E(){
		return E;
	}
	/**
	 * 添加边
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	/**
	 * 与顶点v邻接的所有顶点
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	@Override
	public String toString() {
		return super.toString();
	}
}



















