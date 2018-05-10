package graphics;

import java.util.Stack;

/**
 * 有向图是否有环的判定类
 * @author wenhanglei
 */
public class DirectedCycle {
	
	private boolean[] marked;           //顶点标记数组
	private int[] edgeTo;               //顶点遍历顺序
	private boolean[] onStack;          //是否有环的标记
	private Stack<Integer> cycle;       //保存构成环的顶点
	
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		for(int i = 0; i < G.V(); i++){
			if(!marked[i]) DirectedDFS(G, i);
		}
	}
	
	/**
	 * 有向环是否存在
	 */
	public boolean hasCycle(){
		return cycle != null;
	}
	
	/**
	 * 有向图的深度优先遍历
	 */
	private void DirectedDFS(Digraph G, int w){
		if(hasCycle()) return;
		marked[w] = true;
		onStack[w] = true;
		for(int v : G.adj(w)){
			if(!marked[v]){
				DirectedDFS(G, v);
			}else if(onStack[v]){
				cycle = new Stack<>();
				cycle.push(v);
				while(edgeTo[w] != v){
					cycle.push(w);
					w = edgeTo[w];
				}
			}
		}
		onStack[w] = false;
	}
	
	/**
	 * 有向环的所有顶点
	 */
	public Iterable<Integer> cycle(){
		return cycle;
	}
}
