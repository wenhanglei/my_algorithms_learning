package graphics;
/**
 * 有向图是否有环的判定类
 * @author wenhanglei
 */
public class DirectedCycle {
	
	private Digraph G;
	private boolean[] marked;         //顶点标记数组
	private int[] next;               //顶点遍历顺序
	
	public DirectedCycle(Digraph G) {
		this.G = G;
		marked = new boolean[G.V()];
		next = new int[G.V()];
	}
	
	/**
	 * 有向环是否存在
	 */
	public boolean hasCycle(){
		return false;
	}
	
	/**
	 * 有向图的深度优先遍历
	 */
	private void DirectedDFS(){
	}
	
	/**
	 * 有向环的所有顶点
	 */
	public Iterable<Integer> cycle(){
		return null;
	}
}
