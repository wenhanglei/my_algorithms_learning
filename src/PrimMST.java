
public class PrimMST {
	
	private Edge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	/**
	 * 构造函数
	 * @param G
	 */
	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		//添加顶点0到最小生成树
		distTo[0] = 0;
		visit(G, 0);
	}
	private void visit(EdgeWeightedGraph G, int x) {
		for(Edge v : G.adj(x)) {
			int w = v.other(x);
			//如果该顶点不存在连接到最小生成树的边
			if(edgeTo[w] != null && (v.weight() > distTo[w]))
				continue;
			else if(edgeTo[w] == null)
				edgeTo[w] = v;
			distTo[w] = v.weight();
			pq.insert(w, v.weight());
		}
		int v = pq.delMin();
		if(pq.isEmpty()) return;
		visit(G, v);
	}
	/**
	 * @return 最小生成树的所有边
	 */
	public Iterable<Edge> edges() {
		Queue<Edge> q = new Queue<Edge>();
		for(int i = 1; i < edgeTo.length; i++) {
			q.enqueue(edgeTo[i]);
		}
		return q;
	}
	/**
	 * @return 最小生成树的总权值
	 */
	public double weight() {
		double sum = 0;
		for(int i = 1; i < distTo.length; i++)
			sum += distTo[i];
		return sum;
	}
}














