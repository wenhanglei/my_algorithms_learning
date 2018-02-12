package graphics;
/**
 * 判断一个无向图是否是二分图
 * @author wenhanglei
 */
public class Bipartite {
	
	private boolean[] marked;
	private boolean[] color;
	private boolean isBipartite = true;
	
	/**
	 * 构造函数
	 * @param G
	 */
	public Bipartite(Graph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int i = 0; i < G.V(); i++){
			if(!marked[i]){
				dfs(G, i, true);
			}
		}
	}
	
	private void dfs(Graph G, int v, boolean t){
		marked[v] = true;
		color[v] = t;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w, !t);
			}else if(color[v] == color[w]){
				isBipartite = false;
			}
		}
	}
	
	public boolean isBipartite(){
		return isBipartite;
	}

}
