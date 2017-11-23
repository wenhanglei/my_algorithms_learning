
public class BreadthFirstDirectedPaths {
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	/**
	 * 广度优先遍历查找有向图的最短路径构造函数
	 * @param G
	 * @param s
	 */
	public BreadthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		
		bfs(G, s);
	}
	private void bfs(Digraph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int tmp = queue.dequeue();
			for(int v : G.adj(tmp)){
				if(!marked[v]) {
					marked[v] = true;
					edgeTo[v] = tmp;
					queue.enqueue(v);
				}
			}
		}
	}
	/**
	 * 最短路径是否存在
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	/**
	 * 返回最短路径的迭代器
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = v; i != s; i = edgeTo[i])
			stack.push(i);
		stack.push(s);
		return stack;
	}
}