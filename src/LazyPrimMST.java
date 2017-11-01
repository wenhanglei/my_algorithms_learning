
public class LazyPrimMST {
	
	//��С�������Ķ���Ϊtrue
	private boolean[] marked;
	//���Ӷ������С�������ı�
	private Bag<Edge>[] edgeTo;
	//�ָ���С�������ķָ��
	private MinPQ<Edge> pq;
	
	/**
	 * prim��С���������캯��
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
		//����ö��㵽��С������
		marked[v] = true;
		for(Edge w : G.adj(v)){            //��������v�����б�
			if(!marked[w.other(v)]) {      //���û����Ӹö��㵽��С������
				pq.insert(w);              //��Ӹñߵ���С���ȶ���
			}
		}
		if(pq.isEmpty()) return;
		//��ȡ��С�������ı�
		Edge e = pq.deMin();
		int x = e.either();
		int y = e.other(x);
		while(!(marked[x] && marked[y]))
			e = pq.deMin();
		//�����С�������ı�
		edgeTo[v].add(e);
		visit(G, e.other(v));
	}
	/**
	 * @return ��С�����������б�
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
	 * @return ��С��������Ȩֵ��
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














