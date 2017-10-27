
public class DirectedDFS {
	
	private boolean[] marked;
	
	/**
	 * ����ͼ������ȱ���
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
	 * ������ȱ��������붥�㼯�ϵĿɴ���
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
	 * Դ���Ƿ�ɴﵽ����v
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		return marked[v];
	}

}
