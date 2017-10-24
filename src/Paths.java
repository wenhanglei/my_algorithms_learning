import java.util.Iterator;


public class Paths {
	
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
	public Paths(Graph G, int s) {
		this.edgeTo = new int[G.V()];
		this.marked = new boolean[G.V()];
		this.s = s;
		dfs(G, s);
	}
	private void dfs(Graph G, int s) {
		marked[s] = true;
		for(int v : G.adj(s)) {
			if(!marked[v]) {
				edgeTo[v] = s;
				dfs(G, v);
			}
		}
	}
	/**
	 * ����s��v��·���Ƿ����
	 * @param v
	 */
	public boolean hasPathTo(int v) {
//		int w = edgeTo[v];
//		if(w == s) return true;
//		if(w == edgeTo[w]) return false;
//		return hasPathTo(w);
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
		Paths p = new Paths(g, s);
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

















