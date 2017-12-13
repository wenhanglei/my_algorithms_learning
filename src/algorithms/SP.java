package algorithms;

public class SP {
	
	//最短路径树上的所有边
	private DirectedEdge[] edgeTo;
	//源点s到所有顶点的最短路径
	private double[] distTo;
	//源点
	private int s;
	
	/**
	 * 构造函数
	 * @param G
	 * @param s
	 */
	public SP(EdgeWeightedDigraph G, int s) {
		this.s = s;
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int i = 0; i < G.V(); i++) 
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0;
		
	}
	/**
	 * @param v 
	 * @return 源点s到顶点v的权值和
	 */
	public double distTo(int v) {
		return distTo[v];
	}
	/**
	 * @param v
	 * @return 源点s到顶点v的路径是否存在
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	/**
	 * @param v
	 * @return 源点s到顶点v的路径
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		if(v == s) return stack;
		DirectedEdge e = edgeTo[v];
		stack.push(e);
		while(e.from() != s){
			e = edgeTo[e.from()];
			stack.push(e);
		}
		return stack;
	}
	
	private void relax(DirectedEdge e) {
		if(e == null) return;
		int v = e.from(), w = e.to();
		double dist = distTo[v] + e.weight();
		if(dist < distTo[w]) {
			edgeTo[w] = e;
			distTo[w] = dist;
		}
	}
	
	private void relax(EdgeWeightedDigraph G, int x) {
		for(DirectedEdge e : G.adj(x)) {
			int w = e.to();
			double dist = distTo[x] + e.weight();
			if(dist < distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = dist;
			}
		}
	}
}


















