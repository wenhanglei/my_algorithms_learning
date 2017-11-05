
public class DijkstraSP {
	
	//���·�����ϵ����б�
	private DirectedEdge[] edgeTo;
	//Դ��s�����ж�������·��
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	//Դ��
	private int s;
	
	/**
	 * �Ͽ�˹�����·���㷨
	 * @param G
	 * @param s
	 */
	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		this.s = s;
		for(int i = 0; i < G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		
		distTo[s] = 0;
		visit(G, s);
	}
	
	private void visit(EdgeWeightedDigraph G, int x) {
		for(DirectedEdge e : G.adj(x)) {
			if(distTo(e.to()) < distTo[x] + e.weight()) continue;
			else {
				edgeTo[e.to()] = e;
				pq.insert(e.to(), e.weight());
			}
		}
		double weight = pq.min();
		int i = pq.delMin();
		distTo[i] = weight;
		if(pq.isEmpty()) return;
		visit(G, i);
	}
	
	/**
	 * @param v 
	 * @return Դ��s������v��Ȩֵ��
	 */
	public double distTo(int v) {
		return distTo[v];
	}
	/**
	 * @param v
	 * @return Դ��s������v��·���Ƿ����
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	/**
	 * @param v
	 * @return Դ��s������v��·��
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
