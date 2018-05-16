package graphics;
/**
 * 传递闭包类
 * @author wenhanglei
 */
public class TransitiveClosure {
	
	private boolean[][] reached;
	private boolean[] marked;
	
	/**
	 * 预处理函数
	 */
	public TransitiveClosure(Digraph G) {
		reached = new boolean[G.V()][G.V()];
		for(int i = 0; i < G.V(); i++){
			dfs(G, i);
			for(int j = 0; j < marked.length; j++){
				reached[i][j] = marked[j];
				marked[j] = false;
			}
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
	 * 是否存在一条从v到w的有向路径
	 */
	public boolean reachabile(int v, int w){
		return reached[v][w];
	}

}
