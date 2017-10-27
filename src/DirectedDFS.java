
public class DirectedDFS {
	
	private boolean[] marked;
	
	/**
	 * 有向图深度优先遍历
	 * @param G
	 * @param s
	 */
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	private void dfs(Digraph G, int s) {
		marked[s] = true;
		for(int v : G.adj(s))
			if(!marked[v]) dfs(G, s);
	}
	/**
	 * 深度优先遍历查找与顶点集合的可达性
	 * @param G
	 * @param sources
	 */
	public DirectedDFS(Digraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int x : sources){
			dfs(G, x);
		}
		
	}
	/**
	 * 源点是否可达到顶点v
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		return marked[v];
	}

}
