package algorithms;
/**
 * 强连通图查找
 * @author Administrator
 *
 */
public class KosarajuCC {
	
	private boolean[] marked;
	private int count;
	private int[] id;
	
	/**
	 * 构造函数
	 * @param G
	 */
	public KosarajuCC(Digraph G) {
		/*
		 * 1、 给定一个图，使用DepthFirstOrder算出逆后序得到反图
		 * 2、 在原图上根据逆后序使用深度优先遍历
		 * 3、 在递归函数dfs调用中的所有顶点构成一个强连通分量
		 */
		id = new int[G.V()];
		for(int i = 0; i < id.length; i++)
			id[i] = i;
		marked = new boolean[G.V()];
		Digraph rg = G.reverse();
		DepthFirstOrder dfo = new DepthFirstOrder(G);
		for(int v : dfo.reversePost()){
			if(!marked[v]){
				dfs(rg, v);
				count++;
			}
		}
	}
	private void dfs(Digraph G, int x) {
		marked[x] = true;
		id[x] = count;
		for(int v : G.adj(x)){
			if(!marked[v]) {
				dfs(G, v);
			}
		}
	}
	/**
	 * 顶点v和顶点w是否强连接
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	/**
	 * @return 该有向图的强连通子图的个数
	 */
	public int count() {
		return count;
	}
	/**
	 * @param v 有向图中的顶点
	 * @return 该顶点属于哪个强连通子图
	 */
	public int id(int v) {
		return id[v];
	}
}

















