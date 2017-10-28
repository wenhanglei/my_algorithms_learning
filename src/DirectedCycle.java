import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	
	/**
	 * ���򻷹��캯��
	 * @param G
	 */
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		for(int i = 0; i < marked.length; i++){
			if(!marked[i]){
				dfs(G, i);
			}
		}
	}
	private void dfs(Digraph G, int x) {
		onStack[x] = true;
		marked[x] = true;
		for(int v : G.adj(x)){
			if(this.hasCycle()) return;
			if(!marked[v]){
				edgeTo[v] = x;
				dfs(G, v);
			}else if(onStack[v]){
				cycle = new Stack<Integer>();
				for(int i = v; v != x; v = edgeTo[v])
					cycle.push(i);
				cycle.push(x);
				cycle.push(v);
			}
			onStack[v] = false;
		}
	}
	/**
	 * ����ͼ�Ƿ��л�
	 * @return
	 */
	public boolean hasCycle() {
		return cycle != null;
	}
	/**
	 * ���ػ��ĵ�����
	 * @return
	 */
	public Iterable<Integer> cycle() {
		return cycle;
	}
	
}
