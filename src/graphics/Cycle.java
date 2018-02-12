package graphics;
/**
 * 判断一个图是否为无环图
 * @author wenhanglei
 */
public class Cycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private boolean hasCycle;
	
	/**
	 * 构造函数
	 * @param G
	 */
	public Cycle(Graph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int i = 0; i < G.V(); i++){
			if(!marked[i]){
				dfs(G, i);
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(marked[w] && edgeTo[w] != v)
				hasCycle = true;
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasCycle(){
		return hasCycle;
	}

}
