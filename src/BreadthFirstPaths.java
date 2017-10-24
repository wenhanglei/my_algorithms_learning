
public class BreadthFirstPaths {

	//用于保存路径关系的数组
	private int[] edgeTo;
	//用于记录顶点是否与遍历过
	private boolean[] marked;
	private final int s;
	
	/**
	 * 构造函数
	 * @param G
	 * @param s
	 */
	public BreadthFirstPaths(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	private void bfs(Graph G, int x) {
		Queue<Integer> q = new Queue<Integer>();
		marked[x] = true;
		q.enqueue(x);
		int tmp;
		while(!q.isEmpty()){
			tmp = q.dequeue();
			for(int v : G.adj(tmp))
				if(!marked[v]) {
					edgeTo[v] = tmp;
					marked[v] = true;
					q.enqueue(v);
				}
		}
		
		
//		q.enqueue(x);
//		int tmp;
//		while(!q.isEmpty()){
//			tmp= q.dequeue();
//			if(!marked[tmp]){
//				for(int v : G.adj(tmp)){
//					if(!marked[v]) q.enqueue(v);
//				}
//			}
//			marked[tmp] = true;
//		}
	}
	/**
	 * 连接s，v的路径是否存在
	 * @param v
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	/**
	 * 返回连接s， v的路径
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for(int tmp = v; tmp != s; tmp = edgeTo[tmp])
			stack.push(tmp);
		stack.push(s);
		return stack;
	}
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 *通过控制台参数构造图对象 
		 */
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		Graph g = new Graph(in);
		
		//构造路径对象
		BreadthFirstPaths p = new BreadthFirstPaths(g, s);
		for(int i = 0; i < g.V(); i++) {
			System.out.println(s + " - " + i + ": ");
			if(p.hasPathTo(i)){
				for(int j : p.pathTo(i)){
					if(j == i) System.out.println(j);
					else System.out.print("-" + j);
				}
				System.out.println();
			}
		}
	}

}
