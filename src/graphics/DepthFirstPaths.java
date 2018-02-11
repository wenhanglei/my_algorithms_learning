package graphics;

import java.util.Collections;
import java.util.LinkedList;

public class DepthFirstPaths extends Paths{
	
	private boolean[] marked;
	private final int s;
	private int[] paths;
	
	/**
	 * 构造函数
	 * @param G
	 * @param s
	 */
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		paths = new int[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				paths[w] = v;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(v);
		while(paths[v] != s){
			v = paths[v];
			list.add(v);
		}
		list.add(s);
		Collections.reverse(list);
		return list;
	}
}
