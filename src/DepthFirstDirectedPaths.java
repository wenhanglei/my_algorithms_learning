
public class DepthFirstDirectedPaths {
	
	private int[] edgeTo;
	private boolean[] marked;
	private final int s;
	
	/**
	 * 构造函数
	 * @param G
	 * @param s
	 */
	public DepthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	private void dfs(Digraph G, int x) {
		marked[x] = true;
		for(int v : G.adj(x)) {
			if(!marked[v]) {
				edgeTo[v] = x;
				dfs(G, v);
			}
		}
	}
	/**
	 * 源点s到顶点v的路径是否存在
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	/**
	 * 从源点s到顶点v的路径
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = v; i != s; i = edgeTo[i])
			stack.push(v);
		stack.push(s);
		return stack;
	}
}