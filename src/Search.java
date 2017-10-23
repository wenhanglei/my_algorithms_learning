
public class Search {
	
	private boolean[] marked;
	private int count;
	
	public Search() {
	}
	/**
	 * 带参构造函数
	 * @param g
	 * @param source
	 */
	public Search(Graph G, int s) {
		/*
		 * 深度优先遍历DFS
		 * 1、 标记已经遍历过的顶点
		 * 2、 访问所有没有标记的邻接顶点
		 */
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	/**
	 * 深度优先遍历
	 * @param v
	 */
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int i : G.adj(v)){
			if(!marked[i]) dfs(G, i);
		}
	}
	/**
	 * 顶点v是否和s相连
	 * @param v
	 * @return
	 */
	public boolean Marked(int v) {
		return marked[v];
	}
	/**
	 * 返回与源点相连的所有点的数量
	 * @return
	 */
	public int count() {
		return count;
	}
	
}

















