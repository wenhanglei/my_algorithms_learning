package graphics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {
	
	private boolean[] marked;
	private final int s;
	private int[] edgeTo;

	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}
	
	private void bfs(Graph G, int v){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		marked[v] = true;
		while(!queue.isEmpty()){
			v = queue.poll();
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.offer(w);
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int w = v; w != s; w = edgeTo[w])
			list.add(w);
		list.add(s);
		Collections.reverse(list);
		return list;
	}

}
