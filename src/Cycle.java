
public class Cycle {
	
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G) {
		this.marked = new boolean[G.V()];
		dfs(G, marked);
	}
	private void dfs(Graph G, boolean[] marked) {
		for(int i = 0; i < marked.length; i++){
			if(!marked[i]){
				dfs(G, i, i);
			}
		}
	}
	private void dfs(Graph g, int x, int w){
		marked[x] = true;
		for(int v : g.adj(x)){
			if(!marked[v]) dfs(g, v, x);
			else if(v != w) hasCycle = true;
		}
	}
	
	public boolean isAcylic() {
		return hasCycle;
	}
}
