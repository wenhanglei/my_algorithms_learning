
public class BreadthFirstPaths {

	//���ڱ���·����ϵ������
	private int[] edgeTo;
	//���ڼ�¼�����Ƿ��������
	private boolean[] marked;
	private final int s;
	
	/**
	 * ���캯��
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
	 * ����s��v��·���Ƿ����
	 * @param v
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	/**
	 * ��������s�� v��·��
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
	 * ���Ժ���
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 *ͨ������̨��������ͼ���� 
		 */
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		Graph g = new Graph(in);
		
		//����·������
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
