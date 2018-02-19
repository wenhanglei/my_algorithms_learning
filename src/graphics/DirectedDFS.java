package graphics;

/**
 * 有向图的深度优先查找
 * 处理单源可达性和多源可达性问题
 * @author wenhanglei
 */
public class DirectedDFS {
	
	private boolean[] marked;
	
	/**
	 * 有向图深度优先遍历构造函数
	 * @param G
	 * @param s
	 */
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s : sources){
			if(!marked[s]) dfs(G, s);
		}
	}
	
	private void dfs(Digraph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * 顶点v是否可达
	 * @param v
	 */
	public boolean marked(int v){
		return marked[v];
	}

}
