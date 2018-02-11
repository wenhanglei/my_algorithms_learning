package graphics;
/**
 * 查找无向图中与顶点s相连的顶点是哪些及数量
 * @author wenhanglei
 */
public class Search {
	
	private boolean[] marked;
	private int count;
	
	/**
	 * 构造函数
	 * @param G
	 * @param v
	 */
	public Search(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	/**
	 * 顶点v与源点s是否相连
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return marked[v];
	}
	
	/**
	 * @return 与源点s相连的所有顶点的数量
	 */
	public int count() {
		return count;
	}
	
}
