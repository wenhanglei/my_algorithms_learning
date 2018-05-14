package graphics;
/**
 * 对有向无环图进行拓扑排序
 * @author wenhanglei
 */
public class Topological {
	
	private Iterable<Integer> reversePost;
	
	public Topological(Digraph G) {
		DirectedCycle cycle = new DirectedCycle(G);
		if(!cycle.hasCycle()){
			DepthFirstOrder dfo = new DepthFirstOrder(G);
			reversePost = dfo.reversePost();
		}
	}
	
	/**
	 * 返回该有向图的拓扑序列
	 */
	public Iterable<Integer> order(){
		return reversePost;
	}
	
	/**
	 * 判断该有向图是否是无环图
	 */
	public boolean isDAG(){
		return reversePost != null;
	}

}
