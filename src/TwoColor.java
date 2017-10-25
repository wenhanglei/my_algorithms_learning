
public class TwoColor {
	
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColor = true;
	
	public TwoColor(Graph g) {
		this.marked = new boolean[g.V()];
		this.color = new boolean[g.V()];
		for(int i = 0; i < marked.length; i++) {
			if(!marked[i]) {
				color[i] = true;
				dfs(g, i);
			}
		}
	}
	
	private void dfs(Graph g, int x) {
		marked[x] = true;
		for(int v : g.adj(x)) {
			if(!marked[v]) {
				color[v] = !color[x];
				dfs(g, v);
			}else if(color[v] == color[x]) isTwoColor = false;
			
		}
	}
	
	public boolean isBipartite() {
		return isTwoColor;
	}

}
