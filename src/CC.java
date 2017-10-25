
public class CC {
	
	//顶点遍历标志
	private boolean[] marked;
	//顶点所属的连通子图的id
	private int[] id;
	//连通子图的个数
	private int N;
	
	/**
	 * 连通子图的构造函数
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
	 * 顶点v和w是否相连
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	/**
	 * 连通子图的个数
	 * @return
	 */
	public int count() {
		return N;
	}
	/**
	 * 顶点v属于哪个连通图
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		/*
		 *通过控制台参数构造图对象 
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


















