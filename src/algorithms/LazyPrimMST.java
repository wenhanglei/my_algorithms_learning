package algorithms;

public class LazyPrimMST {
	
	//最小生成树的顶点为true
	private boolean[] marked;
	//连接顶点的最小生成树的边
	private Bag<Edge>[] edgeTo;
	//分割最小生成树的分割边
	private MinPQ<Edge> pq;
	
	/**
	 * prim最小生成树构造函数
	 * @param G
	 */
	public LazyPrimMST(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		edgeTo = (Bag<Edge>[])new Object[G.V()];
		for(int i = 0; i < edgeTo.length; i++) 
			edgeTo[i] = new Bag<Edge>();
		pq = new MinPQ<Edge>(G.V());
		
		visit(G, 0);
		
	}
	private void visit(EdgeWeightedGraph G, int v) {
		//保存该顶点到最小生成树
		marked[v] = true;
		for(Edge w : G.adj(v)){            //遍历连接v的所有边
			if(!marked[w.other(v)]) {      //如果没有添加该顶点到最小生成树
				pq.insert(w);              //添加该边到最小优先队列
			}
		}
		if(pq.isEmpty()) return;
		//获取最小生成树的边
		Edge e = pq.deMin();
		int x = e.either();
		int y = e.other(x);
		while(!(marked[x] && marked[y]))
			e = pq.deMin();
		//添加最小生成树的边
		edgeTo[v].add(e);
		visit(G, e.other(v));
	}
	/**
	 * @return 最小生成树的所有边
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> b = new Bag<Edge>();
		for(int i = 0; i < edgeTo.length; i++) {
			for(Edge e : edgeTo[i]) {
				if(e.other(i) > i) 
					b.add(e);
			}
		}
		return b;
	}
	/**
	 * @return 最小生成树的权值和
	 */
	public double weight() {
		double weight = 0;
		for(int i = 0; i < edgeTo.length; i++){
			for(Edge e : edgeTo[i]){
				if(e.other(i) > i)
					weight += e.weight();
			}
		}
		return weight;
	}
}













