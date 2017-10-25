
public class CC {
	
	//���������־
	private boolean[] marked;
	//������������ͨ��ͼ��id
	private int[] id;
	//��ͨ��ͼ�ĸ���
	private int N;
	
	/**
	 * ��ͨ��ͼ�Ĺ��캯��
	 * @param G
	 */
	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		dfs(G, marked);
	}
	private void dfs(Graph G, boolean[] marked){
		for(int i = 0; i < marked.length; i++){
			if(marked[i] == false) {
				dfs(G, i);
				N++;
			}
		}
	}
	private void dfs(Graph G, int x) {
		marked[x] = true;
		id[x] = N;
		for(int v : G.adj(x)){
			if(!marked[v]) dfs(G, v);
		}
	}
	/**
	 * ����v��w�Ƿ�����
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	/**
	 * ��ͨ��ͼ�ĸ���
	 * @return
	 */
	public int count() {
		return N;
	}
	/**
	 * ����v�����ĸ���ͨͼ
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}
	/**
	 * ���Ժ���
	 */
	public static void main(String[] args) {
		/*
		 *ͨ������̨��������ͼ���� 
		 */
		Graph g = new Graph(new In(args[0]));
		CC cc = new CC(g);
		
		int M = cc.count();
		System.out.println(M + " components");
		
		Bag<Integer>[] components;
		components = (Bag<Integer>[]) new Bag[M];
		for(int i = 0; i < M; i++)
			components[i] = new Bag<Integer>();
		for(int v = 0; v < g.V(); v++)
			components[cc.id(v)].add(v);
		for(int i = 0; i < M; i++){
			for(int v: components[i])
				System.out.print(v + " ");
			System.out.println();
		}
	}
}


















