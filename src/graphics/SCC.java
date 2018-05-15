package graphics;

public class SCC {
	
	private boolean[] marked;
	private int count = 0;
	private int[] components;
	
	public SCC(Digraph G) {
		marked = new boolean[G.V()];
		components = new int[G.V()];
		//获得有向图的反转图
		Digraph reverse = G.reverse();
		//对逆图求拓扑排序获得相应序列
		DepthFirstOrder dfo = new DepthFirstOrder(reverse);
		for(int i : dfo.reversePost()){
			if(!marked[i]){
				dfs(G, i);
				count++;
			}
		}
	}
	
	/**
	 * 深度优先遍历
	 */
	private void dfs(Digraph G, int v){
		marked[v] = true;
		components[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * 判断两个顶点是否是强连通
	 */
	public boolean stronglyConnected(int v, int w){
		return components[v] == components[w];
	}
	
	/**
	 * 返回该有向图的强连通分量的个数
	 */
	public int count(){
		return count;
	}
	
	/**
	 * 返回当前顶点所属的连通分量的标识
	 */
	public int id(int v){
		return components[v];
	}
}
