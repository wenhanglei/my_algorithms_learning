
public class Graph {
	
	//ʹ���ڽ�����������Ϊͼ�ĵײ����ݽṹ
	private Bag<Integer>[] adj;
	//ͼ�Ķ�������
	private final int V;
	//ͼ�ı���
	private int E;
	
	/**
	 * ͼ�Ĺ��캯��
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
	 * ���������캯��
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
	 * ͼ�Ķ�����
	 * @return
	 */
	public int V(){
		return V;
	}
	/**
	 * ͼ�ı���
	 * @return
	 */
	public int E(){
		return E;
	}
	/**
	 * ���ӱ�
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	/**
	 * �붥��v�ڽӵ����ж���
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



















