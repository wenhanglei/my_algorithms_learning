
public class SP {
	
	//���·�����ϵ����б�
	private DirectedEdge[] edgeTo;
	//Դ��s�����ж�������·��
	private double[] distTo;
	//Դ��
	private int s;
	
	/**
	 * ���캯��
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



















