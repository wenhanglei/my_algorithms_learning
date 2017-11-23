
public class KruskalMST {
	
	private boolean[] marked;
	private MinPQ<Edge> pq;
	private int[] vetex;
	private int[] weight;
	private Queue<Edge> mst;
	
	
	/**
	 * 构造函数
	 * @param G
	 */
	public KruskalMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>(G.E());
		vetex = new int[G.V()];
		weight = new int[G.V()];
		mst = new Queue<Edge>();
		marked = new boolean[G.V()];
		//初始化所有的顶点
		for(int i = 0; i < vetex.length; i++) {
			vetex[i] = i;
			weight[i] = 1;
		}
		for(Edge e : G.edges())
			pq.insert(e);
//		dfs(G, 0);
		Edge me;
		while(!pq.isEmpty()){
			me = pq.deMin();
			int v = me.either();
			int w = me.other(v);
			if(connected(v, w)) continue;
			union(v, w);
			mst.enqueue(me);
		}
	}
//	private void dfs(EdgeWeightedGraph G, int x){
//		marked[x] = true;
//		for(Edge e : G.adj(x)){
//			int v = e.other(x);
//			if(!marked[v]){
//				dfs(G, v);
//				pq.insert(e);
//			}
//		}
//	}
	/**
	 * @return 最小生成树中的所有边
	 */
	public Iterable<Edge> edges() {
		return mst;
	}
	/**
	 * @return 最小生成树的总权值
	 */
	public double weight() {
		double sum = 0;
		for(Edge e : mst){
			sum += e.weight();
		}
		return sum;
	}
	
	private boolean connected(int v, int w) {
		return find(v) == find(w);
	}
	
	private int find(int v) {
		while(v != vetex[v]) v = vetex[v];
		return v;
	}
	
	private void union(int v, int w) {
		v = find(v);
		w = find(w);
		if(weight[v] < weight[w]){
			vetex[w] = v;
		}else{
			vetex[v] = w;
		}
	}
}















