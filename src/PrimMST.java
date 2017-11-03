
public class PrimMST {
	
	private Edge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	/**
	 * ���캯��
	 * @param G
	 */
	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		//��Ӷ���0����С������
		distTo[0] = 0;
		visit(G, 0);
	}
	private void visit(EdgeWeightedGraph G, int x) {
		for(Edge v : G.adj(x)) {
			int w = v.other(x);
			//����ö��㲻�������ӵ���С�������ı�
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
	 * @return ��С�����������б�
	 */
	public Iterable<Edge> edges() {
		Queue<Edge> q = new Queue<Edge>();
		for(int i = 1; i < edgeTo.length; i++) {
			q.enqueue(edgeTo[i]);
		}
		return q;
	}
	/**
	 * @return ��С����������Ȩֵ
	 */
	public double weight() {
		double sum = 0;
		for(int i = 1; i < distTo.length; i++)
			sum += distTo[i];
		return sum;
	}
}














