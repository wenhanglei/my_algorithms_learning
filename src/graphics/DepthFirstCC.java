package graphics;

public class DepthFirstCC extends CC {
	
	private boolean[] marked;
	private int[] id;
	private int count;
	
	/**
	 * 构造函数
	 */
	public DepthFirstCC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int i = 0; i < G.V(); i++){
			if(!marked[i]){
				dfs(G, i);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}

	@Override
	public boolean connected(int v, int w) {
		return id(v) == id(w);
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int id(int v) {
		return id[v];
	}

}
