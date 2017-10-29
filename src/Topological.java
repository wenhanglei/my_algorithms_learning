
public class Topological {
	
	private boolean isDAG = true;
	private Iterable<Integer> order;
	/**
	 * 有向无环图的拓扑排序构造函数
	 * @param G
	 */
	public Topological(Digraph G) {
		DirectedCycle dc = new DirectedCycle(G);
		DepthFirstOrder dfo = new DepthFirstOrder(G);
		if(dc.hasCycle()) isDAG = false;
		
		order = dfo.reversePost();
	}
	/**
	 * 该图是否是有向无环图
	 * @return
	 */
	public boolean isDAG() {
		return isDAG;
	}
	/**
	 * 返回该图的拓扑排序
	 * @return
	 */
	public Iterable<Integer> order() {
		return order;
	}
}
