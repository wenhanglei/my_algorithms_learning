
public class EdgeWeightedDigraph {
	
	//�������бߵ�list
	private Bag<DirectedEdge>[] edges;
	//��Ȩ����ͼ���ܵĶ�����
	private final int V;
	//��Ȩ����ͼ�ıߵ�����
	private int E;
	
	/**
	 * ��Ȩ����ͼ�Ĺ��캯��
	 * @param v �ܶ�����
	 */
	public EdgeWeightedDigraph(int v) {
		this.V = v;
		edges = (Bag<DirectedEdge>[]) new Object[v];
		for(int i = 0; i < v; i++) 
			edges[i] = new Bag<DirectedEdge>();
		E = 0;
	}
	
	/**
	 * ��Ȩ����ͼ�Ĺ��캯��
	 * @param in ������
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
	 * @return ��Ȩ����ͼ�Ķ����� 
	 */
	public int V(){
		return V;
	}
	/**
	 * @return ��Ȩ����ͼ�ıߵĸ���
	 */
	public int E(){
		return E;
	}
	/**
	 * ��Ӽ�Ȩ�����
	 * @param e
	 */
	public void addEdge(DirectedEdge e){
		edges[e.from()].add(e);
		E++;
	}
	/**
	 * @param v
	 * @return �����붥��v�����ӵļ�Ȩ�����
	 */
	public Iterable<DirectedEdge> adj(int v) {
		return edges[v];
	}
	/**
	 * @return ���ؼ�Ȩ����ͼ�����б�
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




















